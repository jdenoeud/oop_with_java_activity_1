package com.ocr.justine;

public class Warrior extends Player{


    public Warrior( int playerNumber, int level, int strength, int agility, int intelligence) {
        super(playerNumber, level, strength, agility, intelligence);
    }

    @Override
    public void describe(){
        System.out.println("Woarg je suis le Guerrier Joueur "+this.playerNumber+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }

    @Override
    public void basicAttack(Player target){
        int damagesTarget = this.getStrength();
        target.setLife(target.getLife() - damagesTarget);
        System.out.println("Joueur "+this.getPlayerNumber()+" utilise Coup d'Epée et inflige "+damagesTarget+" dommages.");
        System.out.println("Joueur "+target.getPlayerNumber()+" perd "+ damagesTarget + " points de vie");
        if (target.getLife()<=0)
            System.out.println("Joueur "+target.getPlayerNumber()+" est mort");
    }

    @Override
    public void specialAttack(Player target){
        int damagesTarget = this.getStrength()*2;
        target.setLife(target.getLife() - damagesTarget);
        int damagesAttacker = this.getStrength()/2;
        this.setLife(this.getLife()-damagesAttacker);
        System.out.println("Joueur "+this.getPlayerNumber()+" utilise Coup de Rage et inflige "+damagesTarget+" dommages.");
        System.out.println("Joueur "+target.getPlayerNumber()+" perd "+ damagesTarget + " points de vie");
        if (target.getLife()<=0)
            System.out.println("Joueur "+target.getPlayerNumber()+" est mort");
        System.out.println("Joueur "+this.getPlayerNumber()+" perd "+ damagesAttacker + " points de vie");
        if (this.getLife()<=0)
            System.out.println("Joueur "+this.getPlayerNumber()+" est mort");
    }


}
