package com.ocr.justine;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create Player
        Player player1 = createPlayer(1);
        Player player2;

        player1.describe();
        player2 = createPlayer(2);
        player2.describe();
        System.out.println(player1.getLife());

        /*System.out.println("Joueur "+player1.getPlayerNumber()+" ("+player1.getLife()+") Veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
        Scanner sc = new Scanner(System.in);
        int action = 0;
        do {
            action = sc.nextInt();
            if (action == 1 || action ==2
            )
                responseIsGood = true;
            else
                System.out.println("Vous n'avez pas choisi parmi les 3 classes proposées");
        } while (!responseIsGood);
        Player player = null;
        switch (role    ) {
            case 1:
                player = new Warrior(playerNumber);

                break;
            case 2:
                player = new Prowler(playerNumber);
                break;
            case 3:
                player = new Wizard(playerNumber);
                break;
        }*/
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
