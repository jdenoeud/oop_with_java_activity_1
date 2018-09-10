package com.ocr.justine;

public class Wizard extends Player {

    private int maxLife ;

    public Wizard( int playerNumber, int level, int strength, int agility, int intelligence) {
        super(playerNumber, level, strength, agility, intelligence);
        this.maxLife = this.life;
    }

    @Override
    public void describe(){
        System.out.println("Abracadabra je suis le Mage Joueur "+this.playerNumber+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }

    @Override
    public void basicAttack(Player target){
        int damagesTarget = this.getIntelligence();
        target.setLife(target.getLife() - damagesTarget);
        System.out.println("Joueur "+this.getPlayerNumber()+" utilise Boule de Feu et inflige "+damagesTarget+" dommages.");
        System.out.println("Joueur "+target.getPlayerNumber()+" perd "+ damagesTarget + " points de vie");
        if (target.getLife()<=0)
            System.out.println("Joueur "+target.getPlayerNumber()+" est mort");
    }

    @Override
    public void specialAttack(Player cible){
        int newLifeValue = this.getLife()+ this.getIntelligence()*2;
        int bonus;
        if (newLifeValue < maxLife){
            bonus = this.getIntelligence()*2;
        }
        else {
            bonus = maxLife - newLifeValue;
        }
        this.setLife(this.getLife()+bonus);
        System.out.println("Joueur "+this.getPlayerNumber()+" utilise Soin et gagne "+bonus+" en vitalité.");

    }
}
