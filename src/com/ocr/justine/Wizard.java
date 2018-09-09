package com.ocr.justine;

public class Wizard extends Player {

    public Wizard(int playerNumber) {
        super(playerNumber);
    }

    @Override
    public void describe(){
        System.out.println("Abracadabra je suis le Mage Joueur "+this.playerNumber+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }

    @Override
    public void basicAttack(Player target){
        System.out.println("Attaque basique !");
    }

    @Override
    public void specialAttack(Player cible){
        System.out.println("Attaque spéciale !");
    }
}
