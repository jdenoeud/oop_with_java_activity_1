package com.ocr.justine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WarriorTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    //Testing method describe and constructor

    @Test
    public void Given_WarriorAndLevel40Strength20Agility10Intelligence10_when_describePlayer_Then_DisplayGoodDescription() {
        Warrior warrior = new Warrior(1,40,20,10,10);
        warrior.describe();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Woarg je suis le Guerrier Joueur 1 niveau 40 je possède 200 de vitalité, 20 de force, 10 d'agilité et 10 d'intelligence !", output[0]);
        assertEquals(40, warrior.getLevel());
        assertEquals(200, warrior.getLife());
        assertEquals(20, warrior.getStrength());
        assertEquals(10, warrior.getAgility());
        assertEquals(10, warrior.getIntelligence());

    }


    //testing basicAttack
    @Test
    public void Given_WarriorAttackWizard_when_WarriorBasicAttack_Then_GetGoodLifeValues() {
        Warrior warrior = new Warrior(1,40,20,10,10);
        Wizard target = new Wizard(2,20,0,10,10);
        warrior.basicAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup d'Epée et inflige 20 dommages.", output[0]);
        assertEquals(80, target.getLife());
    }

    @Test
    public void Given_WarriorAttackWizardAndWizardDie_when_WarriorBasicAttacl_Then_GetGoodLifeValues() {
        Warrior warrior = new Warrior(1,40,30,10,0);
        Wizard target = new Wizard(2,5,0,0,5);
        warrior.basicAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup d'Epée et inflige 30 dommages.", output[0]);
        assertEquals(-5, target.getLife());
        assertEquals("Joueur 2 est mort", output[2]);
    }


    //testing specialAttack
    @Test
    public void Given_WarriorAttackWizardWithStrength20_when_WarriorSpecialAttack_Then_GetGoodLifeValues() {
        Warrior warrior = new Warrior(1,40,20,10,10);
        Wizard target = new Wizard(2,20,0,10,10);
        warrior.specialAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup de Rage et inflige 40 dommages.", output[0]);
        assertEquals(60, target.getLife());
        assertEquals(190, warrior.getLife());
    }

    @Test
    public void Given_WarriorAttackWizardWithStrength20AndWizardDie_when_WarriorSpecialAttack_Then_GetGoodLifeValues() {
        Warrior warrior = new Warrior(1,40,20,10,10);
        Wizard target = new Wizard(2,5,0,5,5);
        warrior.specialAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup de Rage et inflige 40 dommages.", output[0]);
        assertEquals(-15, target.getLife());
        assertEquals(190, warrior.getLife());
        assertEquals("Joueur 2 est mort", output[2]);
    }

    @Test
    public void Given_WarriorAttackWizardWithStrength20AndWarriorDie_when_WarriorSpecialAttack_Then_GetGoodLifeValues() {
        Warrior warrior = new Warrior(1,10,10,0,0);
        Wizard target = new Wizard(2,10,0,0,10);
        warrior.setLife(5);
        warrior.specialAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup de Rage et inflige 20 dommages.", output[0]);
        assertEquals(30, target.getLife());
        assertEquals(0, warrior.getLife());
        assertEquals("Joueur 1 est mort", output[3]);
    }

}