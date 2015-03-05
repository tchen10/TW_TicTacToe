package com.thoughtworks.tictactoe;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;


import static org.mockito.Mockito.*;

public class GameTest {
    private PrintStream printStream;
    private Player player1;
    private Player player2;
    private Game game;


    @Before
    public void setUp() {
        this.printStream = mock(PrintStream.class);
        this.player1 = mock(Player.class);
        this.player2 = mock(Player.class);
        this.game = new Game(player1, player2, printStream);
    }

    @Test
    public void shouldDrawInitialGameBoardWhenUserStartsPlaying() {
        game.setInitialGameBoard();
        for (int i = 0; i < 10; i++) {
            String num = "1";
            verify(printStream, times(1)).printf(" " + num + " ");
        }
        verify(printStream, times(6)).printf("|");
    }

    @Test
    public void shouldPutXInRightSpaceWhenPlayerInputs1() {
        when(player1.getPlayerMove()).thenReturn("1");
        game.setInitialGameBoard();
        game.drawOngoingGameBoard(player1);
        verify(printStream).printf(" X ");
    }



}