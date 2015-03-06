package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class GameBoardTest {
    private List<String> boardValues;
    private GameBoard gameBoard;
    private PrintStream printStream;

    @Before
    public void setUp() {
        this.boardValues = new ArrayList<>();
        this.printStream = mock(PrintStream.class);
        this.gameBoard = new GameBoard(boardValues, printStream);
    }


    @Test
    public void shouldPrintInitialGameBoardWithCorrectValues() {
        gameBoard.print();
        assertEquals(boardValues.get(0), " 1 ");
        assertEquals(boardValues.get(2), " 2 ");
        for (int i = 0; i < 10; i++) {
            String num = "1";
            verify(printStream, times(1)).printf(" " + num + " ");
        }
        verify(printStream, times(6)).printf("|");
    }

    @Test
    public void shouldPutXInTopLeftWhenPlayerInputs1() {
        Player player = mock(Player.class);
        when(player.getPlayerMove()).thenReturn("1");
        when(player.getFormattedPlayerSymbol()).thenReturn(" X ");
        gameBoard.setPlayerMove(player);
        assertEquals(boardValues.indexOf(" X "), 0);
    }

    @Test
    public void shouldAddOToBoardWhenPlayer2Inputs2() {
        Player playerOne = mock(Player.class);
        when(playerOne.getPlayerMove()).thenReturn("1");
        when(playerOne.getFormattedPlayerSymbol()).thenReturn(" X ");
        Player playerTwo = mock(Player.class);
        when(playerTwo.getPlayerMove()).thenReturn("2");
        when(playerTwo.getFormattedPlayerSymbol()).thenReturn(" O ");

        gameBoard.setPlayerMove(playerOne);
        gameBoard.setPlayerMove(playerTwo);

        assertEquals(boardValues.indexOf(" X "), 0);
        assertEquals(boardValues.indexOf(" O "), 2);
    }

    @Test
    public void shouldTellUserSpaceIsTakenAndToReEnterWhenSpaceIsTaken() {
        Player playerOne = mock(Player.class);
        when(playerOne.getPlayerMove()).thenReturn("1");
        when(playerOne.getFormattedPlayerSymbol()).thenReturn(" X ");
        Player playerTwo = mock(Player.class);
        when(playerTwo.getPlayerMove()).thenReturn("1").thenReturn("2");
        when(playerTwo.getFormattedPlayerSymbol()).thenReturn(" O ");

        gameBoard.setPlayerMove(playerOne);
        gameBoard.setPlayerMove(playerTwo);

        verify(printStream).println("Location already taken");
        verify(playerTwo, times(2)).getPlayerMove();
    }
}