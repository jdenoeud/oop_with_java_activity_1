package com.ocr.justine;

public class Player {

    private int level;
    private int life;
    private int strength;
    private int agility;
    private int intelligence;
    private int role;

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

    public Player(int role, int level, int strength, int agility, int intelligence) {
        this.role = role;
        this.level = level;
        this.life = (this.level)*5;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void describe(){
        System.out.println("niveau "+this.level+" je possède "+this.life+" de vitalité, "+this.strength+" de force, "+this.agility+" d'agilité et "+this.intelligence+" d'intelligence !"
        );
    }
}
