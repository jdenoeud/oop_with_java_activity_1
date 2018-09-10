package com.ocr.justine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ProwlerTest {
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
    public void Given_ProwlerAndLevel30Strength10Agility20Intelligence0_when_describePlayer_Then_DisplayGoodDescription() {
        Prowler prowler = new Prowler(1,30 ,10,20,0);
        prowler.describe();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Ark je suis le Rôdeur Joueur 1 niveau 30 je possède 150 de vitalité, 10 de force, 20 d'agilité et 0 d'intelligence !", output[0]);
        assertEquals(30, prowler.getLevel());
        assertEquals(150, prowler.getLife());
        assertEquals(10, prowler.getStrength());
        assertEquals(20, prowler.getAgility());
        assertEquals(0, prowler.getIntelligence());

    }


    //testing basicAttack
    @Test
    public void Given_PrawlerAttackTargetWithAgility20_when_ProwlerBasicAttack_Then_GetGoodLifeValues() {
        Prowler prowler = new Prowler(1,30 ,10,20,0);
        Warrior target = new Warrior(2,20,0,10,10);
        prowler.basicAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Tir à l'Arc et inflige 20 dommages.", output[0]);
        assertEquals(80, target.getLife());
    }

    @Test
    public void Given_ProwlerAttackWarriorAndWarriorDie_when_ProwlerBasicAttack_Then_GetGoodLifeValues() {
        Prowler prowler = new Prowler(1,30 ,0,30,0);
        Warrior target = new Warrior(2,5,0,0,5);
        prowler.basicAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Tir à l'Arc et inflige 30 dommages.", output[0]);
        assertEquals(-5, target.getLife());
        assertEquals("Joueur 2 est mort", output[2]);
    }


    //testing specialAttack
    @Test
    public void Given_ProwlerUseSpecialAttackWithLevel30_when_ProwlerSpecialAttack_Then_GetGoodLifeValues() {
        Prowler prowler = new Prowler(1,30 ,0,30,0);
        Wizard target = new Wizard(2,20,0,10,10);
        prowler.specialAttack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Concentration et gagne 15 en agilité.", output[0]);
        assertEquals(45, prowler.getAgility());
    }




}