package com.ocr.justine;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();



    @Test
    public void Given_1WarriorandPlayer1_when_creatingCharacter_Then_DisplayWarriorDescription() {
        Character character = new Character(0,10,0,0 );
        character.describe();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !\n", output);
    }

    @Test
    public void Given_1WizardandPlayer2_when_creatingWizard_Then_DisplayWizardDescription() {
        Character character = new Character(0,10,0,0 );
        character.describe();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !\n", output);
    }

    @Test
    public void Given_1ProwlerandPlayer1_when_creatingProwler_Then_DisplayProwlerDescription() {
        Character character = new Character(0,10,0,0 );
        character.describe();
        String output = outContent.toString().replace("\r\n", "\n");
        assertEquals("Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !\n", output);
    }

}
