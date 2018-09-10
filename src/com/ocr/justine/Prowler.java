package com.ocr.justine;

public class Prowler extends Player{

    /**
     * Construct the Prowler using Player constructor
     * @param playerNumber Number of the player (1 or 2)
     * @param level Level of the player (between 1 and 100)
     * @param strength Strength of the player (between 0 and 100)
     * @param agility Agility of the player (between 0 and 100)
     * @param intelligence Intelligence of the player (between 0 and 100)
     */
    public Prowler( int playerNumber, int level, int strength, int agility, int intelligence) {
        super(playerNumber, level, strength, agility, intelligence);
    }
    /**
     *
     * Describe the player and specify the playerNumber,  role, level, life, strength, agility,and intelligence of the player
     *
     */
    @Override
    public void describe(){
        System.out.println("Ark je suis le Rôdeur Joueur "+this.playerNumber+" niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }

    /**
     * Update target_life (target_life = target_life - attacker_agility)
     * @param target the player attacked
     */
    @Override
    public void basicAttack(Player target){
        int damagesTarget = this.getAgility();
        target.setLife(target.getLife() - damagesTarget);
        System.out.println("Joueur "+this.getPlayerNumber()+" utilise Tir à l'Arc et inflige "+damagesTarget+" dommages.");
        System.out.println("Joueur "+target.getPlayerNumber()+" perd "+ damagesTarget + " points de vie");
        if (target.getLife()<=0)
            System.out.println("Joueur "+target.getPlayerNumber()+" est mort");
    }

    /**
     * Update attacker_agility (attacker_agility = attacker_agility + attacker_level / 2)
     * @param target the player attacked
     */
    @Override
    public void specialAttack(Player target){
        int bonus = this.getLevel() /2;
        this.setAgility(this.getAgility()+bonus);
        System.out.println("Joueur "+this.getPlayerNumber()+" utilise Concentration et gagne "+bonus+" en agilité.");

    }

}
