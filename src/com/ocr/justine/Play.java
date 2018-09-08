package com.ocr.justine;

import java.util.Scanner;

public class Play {

    public void askPlayers(int playerNumber){

    }

    /**
     * Display questions about the player get responses
     */
    public void askPlayer(){
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 - Rôdeur, 3- Mage");
        Scanner sc = new Scanner(System.in);
        int rolePlayer = sc.nextInt();
        System.out.println("Niveau du personnage");
        int level = sc.nextInt();
        System.out.println("Force du personnage");
        int strength = sc.nextInt();
        System.out.println("Agilité du personnage");
        int agility = sc.nextInt();
        System.out.println("Intelligence du personnage");
        int intelligence = sc.nextInt();
        Player joueur1 = new Player(rolePlayer,level,strength, agility, intelligence);
        joueur1.describe();
    }
}
