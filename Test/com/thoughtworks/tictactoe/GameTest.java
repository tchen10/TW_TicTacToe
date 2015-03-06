package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameTest {
    private PrintStream printStream;
    private Player player1;
    private Player player2;
    private GameBoard gameBoard;
    private Game game;


    @Before
    public void setUp() {
        this.printStream = mock(PrintStream.class);
        this.player1 = mock(Player.class);
        this.player2 = mock(Player.class);
        this.gameBoard = mock(GameBoard.class);
        this.game = new Game(player1, player2, gameBoard, printStream);
    }

    @Test
    public void shouldAlternatePlayersWhenGameIsPlaying() {
        game.play();
        verify(gameBoard, times(5)).checkPlayerMove(player1);
        verify(gameBoard, times(4)).checkPlayerMove(player2);
    }

    @Test
    public void shouldCallGameADrawWhenGameIsPlayedToFull() {
        game.play();
        verify(printStream).println("Game is a draw");
    }



}