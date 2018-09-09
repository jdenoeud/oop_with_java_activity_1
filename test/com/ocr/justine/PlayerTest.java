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

   @Test
    public void Given_WarriorLevel10Strength10Agility0Intelligence0_when_creatingPlayer1_Then_DisplayGoodDescription() {
       System.setIn(new ByteArrayInputStream("1\n10\n10\n0\n0\n".getBytes()));
        Player player = new Player(1);
        player.describe();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !", output[6]);
    }

   @Test
    public void Given_WizardLevel10Strength0Agility0Intelligence10_when_creatingPlayer2_Then_DisplayGoodDescription() {
       System.setIn(new ByteArrayInputStream("3\n10\n0\n0\n10\n".getBytes()));
       Player player = new Player(2);
       player.describe();
       String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
       assertEquals("Abracadabra je suis le Mage Joueur 2 niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !", output[6]);
    }

    @Test
    public void Given_BadValueOfRole_when_creatingPlayer_Then_DisplayErrorMessage() {
        System.setIn(new ByteArrayInputStream("5\n1\n10\n10\n0\n0\n".getBytes()));
        Player player = new Player(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Vous n'avez pas choisi parmi les 3 classes proposées", output[2]);
    }

    @Test
    public void Given_BadValueOfLevel_when_creatingPlayer1_Then_DisplayErrorMessage() {
        System.setIn(new ByteArrayInputStream("2\n150\n10\n10\n0\n0\n".getBytes()));
        Player player = new Player(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Le niveau doit être compris entre 1 et 100", output[3]);
    }

    @Test
    public void Given_BadValueOfStrength_when_creatingPlayer_Then_DisplayErrorMessage() {
        System.setIn(new ByteArrayInputStream("2\n10\n20\n0\n0\n10\n".getBytes()));
        Player player = new Player(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Le total force + agilité + intelligence doit être égal au niveau du joueur", output[4]);
    }

    @Test
    public void Given_BadValueOfAgility_when_creatingPlayer_Then_DisplayErrorMessage() {
        System.setIn(new ByteArrayInputStream("2\n10\n10\n10\n0\n0\n".getBytes()));
        Player player = new Player(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Le total force + agilité + intelligence doit être égal au niveau du joueur", output[5]);
    }
    @Test
    public void Given_BadValueOfIntelligence_when_creatingPlayer_Then_DisplayErrorMessage() {
        System.setIn(new ByteArrayInputStream("1\n20\n10\n10\n10\n0\n".getBytes()));
        Player player = new Player(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Le total force + agilité + intelligence doit être égal au niveau du joueur", output[6]);
    }






}