package com.ocr.justine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class WizardTest {

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
    public void Given_WizardAndLevel40Strength20Agility10Intelligence10_when_describePlayer_Then_DisplayGoodDescription() {
        Wizard wizard = new Wizard(2,10,0,0,10);
        wizard.describe();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Abracadabra je suis le Mage Joueur 2 niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !", output[0]);
        assertEquals(10, wizard.getLevel());
        assertEquals(50, wizard.getLife());
        assertEquals(0, wizard.getStrength());
        assertEquals(0, wizard.getAgility());
        assertEquals(10, wizard.getIntelligence());

    }

    //testing basicAttack
    @Test
    public void Given_WizardAttackWarriorWithIntelligence15_when_WizardBasicAttack_Then_GetGoodLifeValues() {
        Wizard wizard = new Wizard(1,15,0,0,15);
        Warrior target = new Warrior(2,20,0,10,10);
        wizard.basicAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Boule de Feu et inflige 15 dommages.", output[0]);
        assertEquals(85, target.getLife());
    }

    @Test
    public void Given_WizardAttackWarriorAndWarriorDie_when_WizardBasicAttack_Then_GetGoodLifeValues() {
        Wizard wizard = new Wizard(2,60,0,0,60);
        Warrior target = new Warrior(1,10,0,10,0);
        wizard.basicAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 2 utilise Boule de Feu et inflige 60 dommages.", output[0]);
        assertEquals(-10, target.getLife());
        assertEquals("Joueur 1 est mort", output[2]);
    }

    //testing specialAttack
    @Test
    public void Given_WizardUseSpecialAttackWithIntelligence10_when_WizardSpecialAttack_Then_GetGoodLifeValues() {
        Wizard wizard = new Wizard(1,20,10,0,10);
        Warrior target = new Warrior(2,20,0,10,10);
        wizard.setLife(5);
        wizard.specialAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Soin et gagne 20 en vitalité.", output[0]);
        assertEquals(25, wizard.getLife());
      }

    @Test
    public void Given_WizardUseSpecialAttackButExceedInitialLife_when_WizardSpecialAttack_Then_GetGoodLifeValues() {
        Wizard wizard = new Wizard(1,20,10,0,10);
        Warrior target = new Warrior(2,20,0,10,10);
        wizard.specialAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Soin et gagne 0 en vitalité.", output[0]);
        assertEquals(100, wizard.getLife());
    }
    @Test
    public void Given_WizardUseSpecialAttackButExceedInitialLife2_when_WizardSpecialAttack_Then_GetGoodLifeValues() {
        Wizard wizard = new Wizard(1,20,10,0,10);
        Warrior target = new Warrior(2,20,0,10,10);
        wizard.setLife(90);
        wizard.specialAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Soin et gagne 10 en vitalité.", output[0]);
        assertEquals(100, wizard.getLife());
    }


}