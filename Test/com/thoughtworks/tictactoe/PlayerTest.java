package com.thoughtworks.tictactoe;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlayerTest {

    @Test
    public void shouldReturnPlayerMoveWhenPrompted() throws IOException {
        BufferedReader reader = mock(BufferedReader.class);
        Player player = new Player("X", reader);

        when(reader.readLine()).thenReturn("1");
        String playerMove = player.getPlayerMove();

        assertEquals(playerMove, "1");

    }



}