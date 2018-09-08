package com.ocr.justine;

public class Character {

    private Integer level;
    private Integer life;
    private Integer strength;
    private Integer agility;
    private Integer intelligence;


    public Character(Integer level, Integer life, Integer strength, Integer agility, Integer intelligence) {
        this.level = level;
        this.life = life;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    /**
     * Display a full description of the character
     */
    public String describe(){
        System.out.println("")
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
    public void BasicAttack(Character character){

    }


}
