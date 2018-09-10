package com.ocr.justine;

import java.util.Scanner;

public class CreatePlayer {
    Scanner sc = new Scanner(System.in);
    public int role;
    private int level;
    private int strength;
    private int agility;
    private int intelligence;

    public Player createPlayer(int playerNumber) {
        System.out.println("Création du personnage du Joueur " + playerNumber);
        this.initRole();
        this.initLevel();
        this.initStrength();
        this.initAgility();
        this.initIntelligence();
        switch (this.role) {
            case 1:
                return new Warrior(playerNumber, this.level, this.strength, this.agility, this.intelligence);
            case 2:
                return new Prowler(playerNumber, this.level, this.strength, this.agility, this.intelligence);
            default:
                return new Wizard(playerNumber, this.level, this.strength, this.agility, this.intelligence);
           }
    }

    private void initRole() {
        boolean responseIsGood = false;
        int response = 0;
        do {
            System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            response = sc.nextInt();
            if (response < 1 || response > 3) {
                System.out.println("Vous n'avez pas choisi parmi les 3 classes proposées");
            } else {
                responseIsGood = true;
            }
        } while (!responseIsGood);
        this.role = response;
    }

    private void initLevel() {
        do {
            System.out.println("Niveau du personnage ?");
            int response = sc.nextInt();
            if (response < 1 || response > 100) {
                System.out.println("La valeur rentrée n'est pas comprise entre 1 et 100");
             } else {
                this.level = response;
            }
            break;
        } while (true);
    }


    private void initStrength() {
        boolean responseIsGood = false;
        do {
            System.out.println("Force du personnage ?");
            int response = sc.nextInt();
            if (response >= 0 && response <= 100) {
                if (response <= this.level) {
                    responseIsGood = true;
                    this.strength = response;
                } else {
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
                 }
            }
            else {
                System.out.println("La force doit être comprise entre 0 et 100");
            }
        } while (!responseIsGood);

    }

    private void initAgility() {
        boolean responseIsGood = false;
        do {
            System.out.println("Agilité du personnage ?");
            int response = sc.nextInt();
            if (response >= 0 && response <= 100) {
                if ((response + this.strength) <= this.level) {
                    responseIsGood = true;
                    this.agility = response;
                } else {
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
                    sc.next();
                }
            }
            else {
                System.out.println("La force doit être comprise entre 0 et 100");
                sc.next();
            }
        } while (!responseIsGood);
    }

    private void initIntelligence() {
        boolean responseIsGood = false;
        do {
            System.out.println("Intelligence du personnage ?");
            int response = sc.nextInt();
            if (response >= 0 && response <= 100) {
                if ((response + this.strength + this.agility) == this.level) {
                    responseIsGood = true;
                    this.intelligence =  response;
                }
                else {
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
                    sc.next();
                }
            }
            else {
                System.out.println("La force doit être comprise entre 0 et 100");
                sc.next();
            }
        } while (!responseIsGood);
    }


}