package com.ocr.justine;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /*@Test
    public void Given_1WarriorandPlayer1_when_creatingCharacter_Then_DisplayWarriorDescription() {
        Player player = new Player(1,0,10,0,0 );
        player.describe();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !\n", output);
    }

    @Test
    public void Given_1WizardandPlayer2_when_creatingWizard_Then_DisplayWizardDescription() {
        Player player = new Player(3,10,0,0,10 );
        player.describe();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Abracadabra je suis le Mage Joueur 2 niveau 10 je possède 50 de vitalité, 0 de force, 0 d'agilité et 10 d'intelligence !\n", output);
    }

    @Test
    public void Given_1ProwlerandPlayer1_when_creatingProwler_Then_DisplayProwlerDescription() {
        Player player = new Player(2,5,10,0,0 );
        player.describe();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Gollum je suis le Rôdeur Joueur 1 niveau 5 je possède 25 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !\n", output);
    }*/
}