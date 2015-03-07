package com.thoughtworks.tictactoe;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;


import static org.mockito.Mockito.*;

public class GameTest {
    private PrintStream printStream;
    private Player player1;
    private Player player2;
    private GameBoard gameBoard;
    private Game game;
    private int turncount;


    @Before
    public void setUp() {
        this.printStream = mock(PrintStream.class);
        this.player1 = mock(Player.class);
        this.player2 = mock(Player.class);
        this.gameBoard = mock(GameBoard.class);
        this.game = new Game(player1, player2, gameBoard, printStream);
    }

    @Test
    public void shouldPromptForPlayerMoveWhenPlayerTurn() {
        when(player1.makeMove()).thenReturn(" 1 ");
        when(player1.formatSymbol()).thenReturn(" X ");
        when(gameBoard.setPlayerMove(" X ", " 1 ")).thenReturn(true);

        game.play();

        verify(printStream).println("Enter a number between 1-9:");
    }

    @Test
    public void shouldPromptPlayerToReenterIfPlayerMoveIsInvalid() {
        when(player2.makeMove()).thenReturn(" 1 ");
        when(player2.formatSymbol()).thenReturn(" O ");
        when(gameBoard.setPlayerMove(" O ", " 1 ")).thenReturn(false).thenReturn(true);

        game.play();

        verify(printStream).println("Location already taken");
        verify(printStream, times(2)).println("Enter a number between 1-9:");
    }

    @Test
    public void shouldAlternatePlayersWhenGameIsPlaying() {
        game.play();
        verify(gameBoard, times(5)).setPlayerMove(player1.formatSymbol(), player1.makeMove());
        verify(gameBoard, times(4)).setPlayerMove(player2.formatSymbol(), player2.makeMove());
    }

    @Test
    public void shouldCallGameADrawWhenGameIsPlayedToFull() {
        game.play();
        verify(printStream).println("Game is a draw");
    }

    @Test
    public void shouldDisplayMessageWhenPlayerWins() {
        when(gameBoard.isWinningGameBoard(player1)).thenReturn(true);
        when(player1.formatSymbol()).thenReturn(" X ");

        game.play();

        verify(printStream).println("Player X wins!");
    }


}