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


    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getLevel() {
        return level;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public int getLife() {
        return life;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setLife(int life) {
        this.life = life;
    }



    public void attack(Player target) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Joueur " + this.getPlayerNumber() + " (" + this.getLife() +
                           " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");

        do {
            switch (sc.nextInt()) {
                case 1:
                    this.basicAttack(target);
                    return;
                case 2:
                    this.specialAttack(target);
                    return;
                default:
                    System.out.println("Vous n'avez pas choisi parmi les 2 actions proposées");
            }
        } while (true);
    }

    public Player( int playerNumber, int level, int strength, int agility, int intelligence) {
        this.playerNumber = playerNumber;
        this.level = level;
        this.life = (this.level)*5;
        this.strength=strength;
        this.agility = agility;
        this.intelligence = intelligence;

    }


    public abstract void describe();

    public abstract void specialAttack(Player cible);

    public abstract void basicAttack(Player target);
}
