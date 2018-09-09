package com.ocr.justine;

import java.util.Scanner;

public abstract class Player {

    Scanner sc = new Scanner(System.in);

    protected int level;

    public int getPlayerNumber() {
        return playerNumber;
    }

    public String getLife() {
        return life + "Vitalité";
    }

    protected int life;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int playerNumber;

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

    private void setStrength() {
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

    private void setAgility() {
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

    private void setIntelligence() {
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


    public Player( int playerNumber) {
        this.playerNumber = playerNumber;

        this.setLevel();
        this.life = (this.level)*5;
        this.setStrength();
        this.setAgility();
        this.setIntelligence();
    }

    public abstract void describe();

    public abstract void specialAttack(Player cible);

    public abstract void basicAttack();
}
