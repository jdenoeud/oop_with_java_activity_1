package com.ocr.justine;

public class Warrior extends Player{


    public Warrior(int playerNumber) {
        super(playerNumber);
    }

    @Override
    public void describe(){
        System.out.println("Woarg je suis le Guerrier Joueur "+this.playerNumber+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }

    @Override
    public void basicAttack(){
        System.out.println("Attaque basique !");
    }

    @Override
    public void specialAttack(){
        System.out.println("Attaque spéciale !");
    }


}
