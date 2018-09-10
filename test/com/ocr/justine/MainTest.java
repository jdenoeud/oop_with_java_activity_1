package com.ocr.justine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

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
    void main() {
    }

    @Test
    void Given_Player1Warrior_When_CreatePlayer_Then_DisplayGoodDescription() {
        System.setIn(new ByteArrayInputStream("1\n10\n10\n0\n0\n".getBytes()));
        Main main = new Main();
        Player warrior = main.createPlayer(1);
        warrior.describe();
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !", output[6]);

    }

    @Test
    void Given_BadValue_When_CreatePlayer_Then_DisplayGoodDescription() {
        System.setIn(new ByteArrayInputStream("1\n".getBytes()));
        Main main = new Main();
        Player player = main.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Vous n'avez pas choisi parmi les 3 classes proposées", output[2]);

    }
}

/*    @Test
    public void Given_WarriorLevel10Strength10Agility0Intelligence0_when_creatingPlayer1_Then_DisplayGoodDescription() {
           System.setIn(new ByteArrayInputStream("10\n10\n0\n0\n".getBytes()));
           Warrior player = new Warrior(1);
           player.describe();
           String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
           //assertEquals("Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !", output[4]);
           assertEquals(1, 1);
    }*/