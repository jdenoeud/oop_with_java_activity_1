package com.ocr.justine;

import java.util.InputMismatchException;
import java.util.Scanner;


public abstract class Player {

    protected int life;
    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int playerNumber;
    protected int level;


    /**
     * @return player's strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @return player's agility
     */
    public int getAgility() {
        return agility;
    }

    /**
     * @return player's intelligence
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * @return player's level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return player's number (1 or 2)
     */
    public int getPlayerNumber() {
        return playerNumber;
    }

    /**
     * @return player's vitality
     */
    public int getLife() {
        return life;
    }

    /**
     * Set the attribute strength
     * @param strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Set the attribute agility
     * @param agility
     */
    public void setAgility(int agility) {
        this.agility = agility;
    }

    /**
     *  Set the attribute intelligence
     * @param intelligence
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Set the attribute level
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * Set the attribute life
     * @param life
     */
    public void setLife(int life) {
        this.life = life;
    }


    /**
     * Asks the player to choose an attack, and launches it
     *  @param target the player attacked
     */
    public void attack(Player target) {
        Scanner sc = new Scanner(System.in);
        int response = 0;
        boolean responseIsGood;
        do {
            System.out.println("Joueur " + this.getPlayerNumber() + " (" + this.getLife() +
                    " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
            try {
                response = sc.nextInt();
                responseIsGood = (response>=1 && response <=2);
            } catch (InputMismatchException e) {
                sc.next();
                responseIsGood = false;
            }

            if (responseIsGood && response == 1)
                this.basicAttack(target);
            else if (responseIsGood)
                this.specialAttack(target);
            else
                System.out.println("Vous n'avez pas choisi parmi les 2 actions proposées");
        } while (!responseIsGood);
    }

    /**
     * Construct the player
     * @param playerNumber Number of the player (1 or 2)
     * @param level Level of the player (between 1 and 100)
     * @param strength Strength of the player (between 0 and 100)
     * @param agility Agility of the player (between 0 and 100)
     * @param intelligence Intelligence of the player (between 0 and 100)
     */
    public Player (int playerNumber, int level, int strength, int agility, int intelligence) {
        this.playerNumber = playerNumber;
        this.level = level;
        this.life = (this.level)*5;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    /**
     * Describe the player and specify the playerNumber, role, level, life, strength, agility, and intelligence of the player
     */
    public abstract void describe();

    /**
     * Use the basic Attack to attack the other player
     * @param target the player attacked
     */
    public abstract void specialAttack(Player target);

    /**
     * Use the Special Attack to attack the other player
     * @param target the player attacked
     */
    public abstract void basicAttack(Player target);
}
