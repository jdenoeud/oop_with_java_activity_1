package com.ocr.justine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {

    Scanner sc = new Scanner(System.in);

    public void askPlayers(int playerNumber){
        for(int i=1; i<=playerNumber; i++){
            System.out.println("Création du personnage du joueur "+ i);
            this.askPlayer();
        }
    }

    /**
     * Display questions about the player and get responses
     */
    public void askPlayer(){
        int rolePlayer = this.askRole();
        int level = this.askSkill("Niveau",1,100);
        int strength = this.askSkill("Force",0,100);
        int agility = this.askSkill("Agilité",0,100);
        int intelligence = this.askSkill("Intelligence",0,100);

    }
    public int askSkill(String skill, int minValue, int maxValue){
        System.out.println(skill+" du personnage");
       int response = 0;
        boolean responseIsGood = false;
        do{
            response = sc.nextInt();
            if (response >=minValue && response <=maxValue)
                responseIsGood  = true;
            else
                System.out.println("La valeur doit être comprise entre "+minValue+" et "+maxValue);

        } while ( !responseIsGood);
        return response;
    }

    public int askRole(){
        System.out.println("Veuillez choisir la classe de votre personnage (1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
        int response = 0;
        boolean responseIsGood = false;
        do{
            response = sc.nextInt();
            if (response >=1 && response <=3)
                responseIsGood  = true;
            else
                System.out.println("Vous n'avez pas choisi parmi les 3 classes");

        } while ( !responseIsGood);
        return response;
    }


}
