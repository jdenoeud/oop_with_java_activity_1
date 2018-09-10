package com.ocr.justine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CreatePlayerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }



    //testing initRole
    @Test
    void Given_Warrior_When_CreatePlayer_GetGoodRoleNumber() {
        System.setIn(new ByteArrayInputStream("1\n10\n10\n0\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(1, createPlayer.getRole());
    }

    @Test
    void Given_Prowler_When_CreatePlayer_GetGoodRoleNumber() {
        System.setIn(new ByteArrayInputStream("2\n10\n10\n0\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(2, createPlayer.getRole());
    }

    @Test
    void Given_NegativeValueOfRole_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("-2.5\n2\n10\n10\n0\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Vous n'avez pas choisi parmi les 3 classes proposées", output[2]);
        assertEquals("Niveau du personnage ?", output[4]);
    }

    @Test
    void Given_BadRoleValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("5\n2\n10\n10\n0\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Vous n'avez pas choisi parmi les 3 classes proposées", output[2]);
        assertEquals("Niveau du personnage ?", output[4]);
    }

    //tests on initLevel
    @Test
    void Given_WarriorWithLevel20_When_CreatePlayer_Then_GetGoodLevel() {
        System.setIn(new ByteArrayInputStream("1\n20\n10\n10\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(20, createPlayer.getLevel());
    }

    @Test
    void Given_WarriorWithBadLevelValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("1\n200\n10\n10\n0\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Le niveau doit être compris entre 1 et 100", output[3]);
    }

    @Test
    void Given_WarriorWithNegativeLevelValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("1\n-5.3\n10\n10\n0\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Le niveau doit être compris entre 1 et 100", output[3]);
    }

    //tests on initStrength
    @Test
    void Given_WizardWithLevel30AndStrengt10_When_CreatePlayer_Then_GetGoodStrength() {
        System.setIn(new ByteArrayInputStream("3\n30\n10\n10\n10\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(10, createPlayer.getStrength());
    }

    @Test
    void Given_WizardAndBadStrengthValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("3\n30\n200\n10\n10\n10\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("La force doit être comprise entre 0 et 100", output[4]);
    }

    @Test
    void Given_WizardAndNotIntegerStrengthValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("3\n30\n-5.6\n10\n10\n10\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("La force doit être comprise entre 0 et 100", output[4]);
    }

    @Test
    void Given_WizardAndStrengthValueSuperiortoLevelValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("3\n30\n60\n10\n10\n10\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Le total force + agilité + intelligence doit être égal au niveau du joueur", output[4]);
    }

    //tests on initAgility
    @Test
    void Given_ProwlerWithLevel30Strengt5Agility25_When_CreatePlayer_Then_GetGoodStrength() {
        System.setIn(new ByteArrayInputStream("2\n30\n5\n25\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(25, createPlayer.getAgility());
    }

    @Test
    void Given_WizardAndBadAgilityValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("2\n30\n5\n150\n25\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("L'agilité doit être comprise entre 0 et 100", output[5]);
    }

    @Test
    void Given_WizardAndNotIntegerAgilityValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("2\n30\n5\n4.55\n25\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("L'agilité doit être comprise entre 0 et 100", output[5]);
    }

    @Test
    void Given_WizardAndStrengthAndAgiltyValueSuperiortoLevelValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("2\n30\n5\n50\n25\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Le total force + agilité + intelligence doit être égal au niveau du joueur", output[5]);
    }

    //tests on initIntelligence
    @Test
    void Given_WarriorWithLevel40Strengt20Agility10Intelligence10_When_CreatePlayer_Then_GetGoodStrength() {
        System.setIn(new ByteArrayInputStream("1\n40\n20\n10\n10\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(10, createPlayer.getIntelligence());
    }

    @Test
    void Given_WizardAndBadIntelligenceValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("1\n40\n20\n10\n150\n10\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("L'intelligence doit être comprise entre 0 et 100", output[6]);
    }

    @Test
    void Given_WizardAndNotIntegerForIntelligenceValue_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("1\n40\n20\n10\n8.996\n10\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("L'intelligence doit être comprise entre 0 et 100", output[6]);
    }

    @Test
    void Given_WizardAndSumOfStrengthAgilityIntelligenceInferiorToLevel_When_CreatePlayer_Then_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("1\n40\n20\n10\n5\n10\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Le total force + agilité + intelligence doit être égal au niveau du joueur", output[6]);
    }





}