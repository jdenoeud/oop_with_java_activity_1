package com.ocr.justine;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // Create Player
        Player player1;
        Player player2;
        player1 = createPlayer(1);
        player1.describe();
        player2 = createPlayer(2);
        player2.describe();
        }

    public static Player createPlayer(int playerNumber) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Création du personnage du Joueur " + playerNumber);
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        int role = 0;
        boolean responseIsGood = false;
        do {
            role = sc.nextInt();
            if (role >= 1 && role <= 3)
                responseIsGood = true;
            else
                System.out.println("Vous n'avez pas choisi parmi les 3 classes proposées");
        } while (!responseIsGood);
        Player player = null;
        switch (role) {
            case 1:
                player = new Warrior(playerNumber);

                break;
            case 2:
                player = new Prowler(playerNumber);
              break;
            case 3:
                player = new Wizard(playerNumber);
            break;
        }
        return player;

    }
}
