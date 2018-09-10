package com.ocr.justine;

public class Wizard extends Player {

    private int maxLife;

    /**
     * Construct the wizard using player constructor
     *  @param playerNumber Number of the player (1 or 2)
     *  @param level Level of the player (between 1 and 100)
     *  @param strength Strength of the player (between 0 and 100)
     *  @param agility Agility of the player (between 0 and 100)
     *  @param intelligence Intelligence of the player (between 0 and 100)
     */
    public Wizard (int playerNumber, int level, int strength, int agility, int intelligence) {
        super(playerNumber, level, strength, agility, intelligence);
        this.maxLife = this.life;
    }

    /**
     *
     * Describe the player and specify the playerNumber, role, level, life, strength, agility, and intelligence of the player
     *
     */
    @Override
    public void describe() {
        System.out.println("Abracadabra je suis le Mage Joueur " + this.playerNumber + " niveau " + this.level +
                           " je possède " + this.life + " de vitalité, " + this.strength + " de force, " +
                           this.agility + " d'agilité et " + this.intelligence + " d'intelligence !");
    }

    /**
     * Update target_life (target_life = target_life - attacker_intelligence)
     * @param target the player attacked
     */
    @Override
    public void basicAttack(Player target) {
        int damagesTarget = this.getIntelligence();
        target.setLife(target.getLife() - damagesTarget);
        System.out.println("Joueur " + this.getPlayerNumber() + " utilise Boule de Feu et inflige " + damagesTarget + " dommages.");
        System.out.println("Joueur " + target.getPlayerNumber() + " perd " + damagesTarget + " points de vie");
        if (target.getLife() <= 0)
            System.out.println("Joueur " + target.getPlayerNumber() + " est mort");
    }

    /**
     * Update attacker_life (attacker_life = attacker_life + attacker_intelligence*2) but can't be superior to attacker_inital_life value
     * @param target the player attacked
     */
    @Override
    public void specialAttack(Player target) {
        int bonus;
        int newLifeValue = this.getLife() + this.getIntelligence()*2;

        if (newLifeValue < this.maxLife) {
            bonus = this.getIntelligence()*2;
            System.out.println("Joueur " + this.getPlayerNumber() + " utilise Soin et gagne " + bonus + " en vitalité.");
            this.setLife(newLifeValue);
        } else {
            bonus = this.maxLife - this.getLife();
            System.out.println("Joueur " + this.getPlayerNumber() + " utilise Soin et gagne " + bonus + " en vitalité.");
            this.setLife(maxLife);
        }
    }
}
