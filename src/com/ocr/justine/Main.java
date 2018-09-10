package com.ocr.justine;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        createPlayer(1);
        // Create players
        Player player1 = createPlayer(1);
        player1.describe();
        Player player2 = createPlayer(2);
        player2.describe();

        // Fight until the end
        do {
            // Player1 attacks first
            player1.attack(player2);
            if (player1.getLife() <= 0 || player2.getLife() <= 0)
                break;

            // Then player2 attacks
            player2.attack(player1);
            if (player1.getLife() <= 0 || player2.getLife() <= 0)
                break;
        } while (true);

        // This is the end
        if (player1.getLife() <= 0)
            System.out.println("Joueur " +
                    "1 a perdu !");
        else
            System.out.println("Joueur 2 a perdu !");
    }

    public static Player createPlayer(int playerNumber) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Création du personnage du Joueur " + playerNumber);
        int role = sc.nextInt();
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
}


 /* do {
            System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
            int role = 0;
            role = sc.nextInt();

            if (role < 1 || role > 3) {
                System.out.println("Vous n'avez pas choisi parmi les 3 classes proposées");
                sc.next();
            } else {
                responseIsGood = true;
            }

        } while (!responseIsGood);

        do {
            System.out.println("Niveau du personnage ?");
            int level = sc.nextInt();
            if (level < 1 || level > 100) {
                System.out.println("La valeur rentrée n'est pas comprise entre 1 et 100");
                sc.next();
            } else {
                break;
            }
        } while (true);*/