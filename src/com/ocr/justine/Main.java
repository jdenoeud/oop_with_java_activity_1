package com.ocr.justine;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create Player
        Player player1 = createPlayer(1);
        player1.describe();
        Player player2 = createPlayer(2);
        player2.describe();

        //Play
        attack(player1, player2);
        attack(player2, player1);
        attack(player1, player2);
        attack(player2, player1);

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

    public static void attack(Player attacker, Player target) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Joueur "+attacker.getPlayerNumber()+" ("+ attacker.getLife()+" Vitalité) Veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
        int action = 0;
        boolean responseIsGood = false;
        do {
            action = sc.nextInt();
            switch (action) {
                case 1:
                     attacker.basicAttack(target);
                     responseIsGood=true;
                     break;
                case 2:
                    attacker.specialAttack(target);
                    responseIsGood=true;
                    break;
                default:
                    System.out.println("Vous n'avez pas choisi parmi les 2 actions proposées");
            }
        } while (!responseIsGood);
    }

}
