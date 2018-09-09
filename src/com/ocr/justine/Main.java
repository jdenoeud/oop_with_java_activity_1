package com.ocr.justine;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Create Player
        for (int i = 1; i <= 2; i++) {
            int role = createPlayer(i);
            switch (role) {
                case 1:
                    Warrior warrior = new Warrior(i);
                    warrior.describe();
                    break;
                case 2:
                    Prowler prowler = new Prowler(i);
                    prowler.describe();
                    break;
                case 3:
                    Wizard wizard = new Wizard(i);
                    wizard.describe();
                    break;
            }
        }


        //Play
    }

    public static int createPlayer(int playerNumber) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Création du personnage du Joueur "+ playerNumber);
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
        return role;
    }
}
