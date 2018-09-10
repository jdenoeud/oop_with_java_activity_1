package com.ocr.justine;


public class Main {


    public static void main(String[] args) {

        // Create players
        CreatePlayer createPlayer = new CreatePlayer();
        Player player1 = createPlayer.createPlayer(1);
        player1.describe();
        Player player2 = createPlayer.createPlayer(2);
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
            System.out.println("Joueur 1 a perdu !");
        else
            System.out.println("Joueur 2 a perdu !");
    }

}

