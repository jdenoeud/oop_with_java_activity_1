package com.ocr.justine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    //Testing method attack
    @Test
    public void Given_WarriorAttackWizard_when_WarriorBasicAttack_Then_GetGoodLifeValues() {
        System.setIn(new ByteArrayInputStream("1\n2\n".getBytes()));
        Warrior warrior = new Warrior(1,40,20,10,10);
        Wizard target = new Wizard(2,20,0,10,10);
        warrior.attack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Joueur 1 utilise Coup d'Epée et inflige 20 dommages.", output[1]);
        assertEquals(80, target.getLife());
    }

    @Test
    void Given_BadValueOfAttackNumber_When_PlayerAttack_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("3\n2\n".getBytes()));
        Warrior warrior = new Warrior(1,40,20,10,10);
        Wizard target = new Wizard(2,20,0,10,10);
        warrior.attack(target);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Vous n'avez pas choisi parmi les 2 actions proposées", output[1]);
    }



}