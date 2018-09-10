package com.ocr.justine;

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
        System.out.println("Niveau du personnage ?");
        int level = sc.nextInt();
        System.out.println("Force du personnage ?");
        int strength = sc.nextInt();
        System.out.println("Agilité du personnage ?");
        int agility = sc.nextInt();
        System.out.println("Intelligence du personnage ?");
        int intelligence = sc.nextInt();

        switch (role) {
            case 1:
                return new Warrior(playerNumber, level, strength, agility, intelligence);
            case 2:
                return new Prowler(playerNumber, level, strength, agility, intelligence);
            default:
                return new Wizard(playerNumber, level, strength, agility, intelligence);

        }
    }

    public void initRole() {
        boolean responseIsGood = false;
        int response = 0;
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        do{
            role = sc.nextInt();
            if (role < 1 || role > 3) {
                System.out.println("Vous n'avez pas choisi parmi les 3 classes proposées");
                sc.next();
            } else {
                responseIsGood = true;
            }
        } while (!responseIsGood);
        this.role = response;

    }
}
