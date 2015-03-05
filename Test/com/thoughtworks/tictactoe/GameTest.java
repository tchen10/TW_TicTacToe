package com.thoughtworks.tictactoe;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
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
    public void shouldPutXWhenPlayer1Inputs() {
        when(player1.getPlayerMove()).thenReturn("1");
        when(player1.getFormattedPlayerXO()).thenReturn(" X ");
        game.setInitialGameBoard();
        game.drawOngoingGameBoard(player1);
        verify(printStream).printf(" X ");
    }

    @Test
    public void shouldAddOToBoardWhenPlayer2Inputs() {
        when(player1.getPlayerMove()).thenReturn("1");
        when(player1.getFormattedPlayerXO()).thenReturn(" X ");
        when(player2.getPlayerMove()).thenReturn("2");
        when(player2.getFormattedPlayerXO()).thenReturn(" O ");

        game.setInitialGameBoard();
        game.drawOngoingGameBoard(player1);
        game.drawOngoingGameBoard(player2);

        verify(printStream).printf(" O ");
        verify(printStream, times(2)).printf(" X ");

    }

    @Test
    public void shouldTellUserSpaceIsTakenWhenSpaceIsTaken() {
        when(player1.getPlayerMove()).thenReturn("1");
        when(player1.getFormattedPlayerXO()).thenReturn(" X ");
        when(player2.getPlayerMove()).thenReturn("1");
        when(player2.getFormattedPlayerXO()).thenReturn(" O ");

        game.setInitialGameBoard();
        game.drawOngoingGameBoard(player1);
        game.drawOngoingGameBoard(player2);

        verify(printStream).println("Location already taken");
    }

    @Test
    public void shouldAlternateUsersUntilGameBoardIsFull() {

    }


}