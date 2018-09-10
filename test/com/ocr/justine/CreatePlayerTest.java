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

    @Test
    void createPlayer() {
    }

    //testing initRole
    @Test
    void Given_Player1IsAWarrior_When_CreatePlayer_GetGoodRoleNumber() {
        System.setIn(new ByteArrayInputStream("1\n10\n10\n0\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(1);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(1, createPlayer.role);
    }

    @Test
    void Given_Player2IsAProwler_When_CreatePlayer_GetGoodRoleNumber() {
        System.setIn(new ByteArrayInputStream("2\n10\n10\n0\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals(2, createPlayer.role);
    }

    @Test
    void Given_BadValueOfRole_When_CreatePlayer_GetErrorMessage() {
        System.setIn(new ByteArrayInputStream("5\n2\n10\n10\n0\n0\n".getBytes()));
        CreatePlayer createPlayer = new CreatePlayer();
        createPlayer.createPlayer(2);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Vous n'avez pas choisi parmi les 3 classes proposées", output[2]);
    }


    //test initRole





}