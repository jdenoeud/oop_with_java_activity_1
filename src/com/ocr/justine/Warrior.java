package com.ocr.justine;

public class Warrior extends Player{


    /**
     * Construct the warrior using Player Constructor
     * @param playerNumber Number of the player (1 or 2)
     * @param level Level of the player (between 1 and 100)
     * @param strength Strength of the player (between 0 and 100)
     * @param agility Agility of the player (between 0 and 100)
     * @param intelligence Intelligence of the player (between 0 and 100)
     */
    public Warrior( int playerNumber, int level, int strength, int agility, int intelligence) {
        super(playerNumber, level, strength, agility, intelligence);
    }

    /**
     *
     * Describe the player and specify the playerNumber,  role, level, life, strength, agility,and intelligence of the player
     *
     */
    @Override
    public void describe(){
        System.out.println("Woarg je suis le Guerrier Joueur "+this.playerNumber+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }


    /**
     * Update target_life (target_life = target_life - attacker_strength)
     * @param target the player attacked
     */
    @Override
    public void basicAttack(Player target){
        int damagesTarget = this.getStrength();
        target.setLife(target.getLife() - damagesTarget);
        System.out.println("Joueur "+this.getPlayerNumber()+" utilise Coup d'Epée et inflige "+damagesTarget+" dommages.");
        System.out.println("Joueur "+target.getPlayerNumber()+" perd "+ damagesTarget + " points de vie");
        if (target.getLife()<=0)
            System.out.println("Joueur "+target.getPlayerNumber()+" est mort");
    }

    /**
     * Update target_life (target_life = target_life - attacker_strength*2)
     * Update attacker_life (attacker_life = attacker_life - attacker_strength/2)
     * @param target the player attacked
     */
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
