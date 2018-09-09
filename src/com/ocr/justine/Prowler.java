package com.ocr.justine;

public class Prowler extends Player{
    public Prowler(int playerNumber) {
        super(playerNumber);
    }

    @Override
    public void describe(){
        System.out.println("Ark je suis le Rôdeur Joueur "+this.playerNumber+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }

    @Override
    public void basicAttack(Player target){
        int damagesTarget = this.getAgility();
        target.setLife(target.getLife() - damagesTarget);
        System.out.println("Joueur "+this.getPlayerNumber()+" utilise Tir à l'arc et inflige "+damagesTarget+" dommages.");
        System.out.println("Joueur "+target.getPlayerNumber()+" perd "+ damagesTarget + " points de vie");
    }

    @Override
    public void specialAttack(Player cible){
        System.out.println("Attaque spéciale !");
    }

}
