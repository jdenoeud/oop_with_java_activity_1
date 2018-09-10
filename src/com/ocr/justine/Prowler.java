package com.ocr.justine;

public class Prowler extends Player{

    public Prowler( int playerNumber, int level, int strength, int agility, int intelligence) {
        super(playerNumber, level, strength, agility, intelligence);
    }

    @Override
    public void describe(){
        System.out.println("Ark je suis le Rôdeur Joueur "+this.playerNumber+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }

    @Override
    public void basicAttack(Player target){
        int damagesTarget = this.getAgility();
        target.setAgility(target.getAgility() - damagesTarget);
        System.out.println("Joueur "+this.getPlayerNumber()+" utilise Tir à l'arc et inflige "+damagesTarget+" dommages.");
        System.out.println("Joueur "+target.getPlayerNumber()+" perd "+ damagesTarget + " points de vie");
        if (target.getLife()<=0)
            System.out.println("Joueur "+target.getPlayerNumber()+" est mort");
    }

    @Override
    public void specialAttack(Player target){
        int bonus = this.getLevel() /2;
        this.setAgility(this.getAgility()+bonus);
        System.out.println("Joueur "+this.getPlayerNumber()+" utilise Concentration et gagne "+bonus+" en agilité.");

    }

}
