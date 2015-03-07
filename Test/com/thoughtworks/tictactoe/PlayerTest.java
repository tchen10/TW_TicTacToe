package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private BufferedReader reader;
    private Player player;

    @Before
    public void setUp() {
        this.reader = mock(BufferedReader.class);
        this.player = new Player("X", reader);
    }

    @Test
    public void shouldReturnFormattedPlayerMoveWhenPrompted() throws IOException {
        when(reader.readLine()).thenReturn("1");
        String playerMove = player.makeMove();
        assertEquals(playerMove, " 1 ");

    }

    @Test
    public void shouldReturnFormattedXOForPlayer() {
        String result = player.formatSymbol();
        assertEquals(result, " X ");

    }

}