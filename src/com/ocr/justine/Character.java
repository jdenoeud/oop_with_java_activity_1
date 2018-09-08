package com.ocr.justine;

public class Character {

    protected int level;
    protected int life;
    protected int strength;
    protected int agility;
    protected int intelligence;

    public int getLevel() {
        return level;
    }

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

     public Character(int level, int strength, int agility, int intelligence) {
        this.level = level;
        this.life = (this.level)*5;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }


    /**
     * Display a full description of the character
     */
    public void describe(){
        System.out.println("niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }


    /**
     * Run a basic attack that causes damages to the opponent
     * @param character attacked
     */
    public void BasicAttack(Character character){

    }

    /**
     * Run a special attack with various effects
     * @param character attacked
     */
    public void SpecialAttack(Character character){

    }


}
