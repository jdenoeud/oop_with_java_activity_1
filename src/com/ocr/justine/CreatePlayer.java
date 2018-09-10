package com.ocr.justine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreatePlayer {
    Scanner sc = new Scanner(System.in);
    private int role;
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
            try {
                response = sc.nextInt();
               responseIsGood = (response >= 1 && response <= 3);
            } catch (InputMismatchException e){
                sc.next();
                responseIsGood=false;
             }
           if (!responseIsGood)
               System.out.println("Vous n'avez pas choisi parmi les 3 classes proposées");

        } while (!responseIsGood);
        this.role = response;
    }

    private void initLevel() {
        boolean responseIsGood = false;
        int response = 0;
        do {
            System.out.println("Niveau du personnage ?");
            try {
                response = sc.nextInt();
                responseIsGood = (response>=1 && response <=100);
            } catch (InputMismatchException e) {
                sc.next();
                responseIsGood = false;
            }
            if (!responseIsGood)
                System.out.println("Le niveau doit être compris entre 1 et 100");

        } while (!responseIsGood);
        this.level = response;
    }

    private void initStrength() {
        boolean responseIsGood = false;
        int response = 0;
        do {
            System.out.println("Force du personnage ?");
            try {
                response = sc.nextInt();
                responseIsGood = (response>=0 && response <=100);
            } catch (InputMismatchException e) {
                sc.next();
                responseIsGood = false;
            }
            if (responseIsGood) {
                if (response <= this.level) {
                    this.strength = response;
                } else {
                    responseIsGood=false;
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
        int response = 0;
        do {
            System.out.println("Agilité du personnage ?");
            try {
                response = sc.nextInt();
                responseIsGood = (response >= 0 && response <= 100);
            } catch (InputMismatchException e) {
                sc.next();
                responseIsGood = false;
            }
            if (responseIsGood) {
                if ((response + this.strength) <= this.level) {
                    this.agility = response;
                } else {
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
                    responseIsGood=false;
                }
            }
            else{
                System.out.println("L'agilité doit être comprise entre 0 et 100");
            }
        } while (!responseIsGood);
    }

    private void initIntelligence() {
        boolean responseIsGood = false;
        int response = 0;
        do {
            System.out.println("Intelligence du personnage ?");
            try{
                response = sc.nextInt();
                responseIsGood = (response >= 0 && response <= 100);
            } catch (InputMismatchException e) {
                sc.next();
                responseIsGood = false;
            }
            if (responseIsGood) {
                if ((response + this.strength + this.agility) == this.level) {
                    this.intelligence =  response;
                }
                else {
                    responseIsGood = false;
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
                }
            }
            else {
                System.out.println("L'intelligence doit être comprise entre 0 et 100");
            }
        } while (!responseIsGood);
    }

        public int getRole() {
            return role;
        }

        public int getLevel() {
            return level;
        }

        public int getStrength() {
            return strength;
        }

        public int getAgility() {
            return agility;
        }

        public int getIntelligence() {
            return intelligence;
        }


}