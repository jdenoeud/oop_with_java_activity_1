package com.ocr.justine;

import java.util.Scanner;

public class Player {

    Scanner sc = new Scanner(System.in);

    private int level;
    private int life;
    private int strength;
    private int agility;
    private int intelligence;
    private int role;
    private int playerNumber;

    private void setLevel() {
        System.out.println("Niveau du personnage ?");
        int response = 0;
        boolean responseIsGood = false;
        do{
            response = sc.nextInt();
            if (response >=1 && response <=100)
                responseIsGood  = true;
            else
                System.out.println("Le niveau doit être compris entre 1 et 100");

        } while ( !responseIsGood);
        this.level = response;
    }

    public void setStrength() {
        System.out.println("Force du personnage ?");
        int response = 0;
        boolean responseIsGood = false;
        do{
            response = sc.nextInt();
            if (response >=0 && response <=100)
                if (response <= this.level)
                    responseIsGood  = true;
                else
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
            else
                System.out.println("La force doit être comprise entre 0 et 100");
        } while ( !responseIsGood);
        this.strength = response;
    }

    public void setAgility() {
        System.out.println("Agilité du personnage ?");
        int response = 0;
        boolean responseIsGood = false;
        do{
            response = sc.nextInt();
            if (response >=0 && response <=100)
                if ( (response + this.strength) <= this.level)
                    responseIsGood  = true;
                else
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
            else
                System.out.println("La force doit être comprise entre 0 et 100");
        } while ( !responseIsGood);
        this.agility = response;
    }

    public void setIntelligence() {
        System.out.println("Intelligence du personnage ?");
        int response = 0;
        boolean responseIsGood = false;
        do{
            response = sc.nextInt();
            if (response >=0 && response <=100)
                if ( (response + this.strength + this.agility) == this.level)
                    responseIsGood  = true;
                else
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
            else
                System.out.println("La force doit être comprise entre 0 et 100");
        } while ( !responseIsGood);
       this.intelligence = response;
    }

    public void setRole() {
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        int response = 0;
        boolean responseIsGood = false;
            do{
            response = sc.nextInt();
            if (response >=1 && response <=3)
                responseIsGood  = true;
            else
                System.out.println("Vous n'avez pas choisi parmi les 3 classes proposées");

        } while ( !responseIsGood);
            this.role = response;
    }


    public Player( int playerNumber) {
        this.playerNumber = playerNumber;
        System.out.println("Création du personnage du Joueur "+ this.playerNumber);
        this.setRole();
        this.setLevel();
        this.life = (this.level)*5;
        this.setStrength();
        this.setAgility();
        this.setIntelligence();
    }

    public void describe(){
        String roleName = "";
        String playerName = "";
        switch (this.role) {
            case 1:
                roleName = "Guerrier";
                playerName = "Woarg";
                break;
            case 2:
                roleName = "Rôdeur";
                playerName = "Rôdeur";
                break;
            case 3:
                roleName = "Mage";
                playerName = "Abracadabra";
                break;
        }
        System.out.println(playerName +" je suis le "+ roleName +" Joueur "+this.playerNumber+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }

    private int askRole(){
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        int response = 0;
        boolean responseIsGood = false;
        do{
            response = sc.nextInt();
            if (response >=1 && response <=3)
                responseIsGood  = true;
            else
                System.out.println("Vous n'avez pas choisi parmi les 3 classes");

        } while ( !responseIsGood);
        return response;
    }
}
