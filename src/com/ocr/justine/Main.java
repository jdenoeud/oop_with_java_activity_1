package com.ocr.justine;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create players
        Player player1 = createPlayer(1);
        Player player2 = createPlayer(2);
        player1.describe();
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
        } while(true);

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
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        int role = 0;
        do {
            role = sc.nextInt();
            switch (role) {
                case 1:
                    return new Warrior(playerNumber);
                case 2:
                    return new Prowler(playerNumber);
                case 3:
                    return new Wizard(playerNumber);
                default:
                    System.out.println("Vous n'avez pas choisi parmi les 3 classes proposées");
            }
        } while (true);
     }
}
