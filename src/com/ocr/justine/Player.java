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
    Scanner sc = new Scanner(System.in);

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

    public void setLevel(int level) throws PlayerExceptions {
            if (level<1 || level>100)
                throw new PlayerExceptions();
            else
                this.level = level;
    }

    public void setLife(int life) {
        this.life = life;
    }

    private void initLevel() {
        do{
            System.out.println("Niveau du personnage ?");
            try{
                int response = 0;
                response = sc.nextInt();
                setLevel(response);
                break;
            } catch (PlayerExceptions e){
                sc.next();
            }
            catch (InputMismatchException e) {
                System.out.println("La valeur rentrée n'est pas un nombre entier");
                sc.next();
            }
        } while (true);
    }

    private void initStrength() {
        int response = 0;
        boolean responseIsGood = false;

        System.out.println("Force du personnage ?");

        do{
            response = sc.nextInt();
            if (response >=0 && response <=100)
                if (response <= this.level)
                    responseIsGood  = true;
                else
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
            else
                System.out.println("La force doit être comprise entre 0 et 100");
        } while ( !responseIsGood);
        setStrength(response);
    }

    private void initAgility() {
        System.out.println("Agilité du personnage ?");
        int response = 0;
        boolean responseIsGood = false;
        do{
            response = sc.nextInt();
            if (response >=0 && response <=100)
                if ( (response + this.strength) <= this.level)
                    responseIsGood  = true;
                else
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
            else
                System.out.println("La force doit être comprise entre 0 et 100");
        } while ( !responseIsGood);
        setAgility(response);
    }

    private void initIntelligence() {
        System.out.println("Intelligence du personnage ?");
        int response = 0;
        boolean responseIsGood = false;
        do{
            response = sc.nextInt();
            if (response >=0 && response <=100)
                if ( (response + this.strength + this.agility) == this.level)
                    responseIsGood  = true;
                else
                    System.out.println("Le total force + agilité + intelligence doit être égal au niveau du joueur");
            else
                System.out.println("La force doit être comprise entre 0 et 100");
        } while ( !responseIsGood);
       setIntelligence(response);
    }


    public Player( int playerNumber) {
        this.playerNumber = playerNumber;
        this.initLevel();
        this.life = (this.level)*5;
        this.initStrength();
        this.initAgility();
        this.initIntelligence();
    }

    public abstract void describe();

    public abstract void specialAttack(Player cible);

    public abstract void basicAttack(Player target);
}
