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
        verify(printStream).print(" 1 | 2 | 3 \n");
        verify(printStream).print(" 4 | 5 | 6 \n");
        verify(printStream).print(" 7 | 8 | 9 \n");
    }

    @Test
    public void shouldPutXInTopLeftWhenPlayerInputs1() {
        Player player = mock(Player.class);
        when(player.makeMove()).thenReturn(" 1 ");
        when(player.formatSymbol()).thenReturn(" X ");
        gameBoard.setPlayerMove(player.formatSymbol(), player.makeMove());
        assertEquals(boardValues.indexOf(" X "), 0);
        verify(printStream).print(" X | 2 | 3 \n");

    }

    @Test
    public void shouldAddOToBoardWhenPlayer2Inputs2() {
        Player playerTwo = mock(Player.class);
        when(playerTwo.makeMove()).thenReturn(" 2 ");
        when(playerTwo.formatSymbol()).thenReturn(" O ");

        boardValues.set(0, " X ");
        gameBoard.setPlayerMove(playerTwo.formatSymbol(), playerTwo.makeMove());

        assertEquals(boardValues.indexOf(" X "), 0);
        assertEquals(boardValues.indexOf(" O "), 1);
        verify(printStream).print(" X | O | 3 \n");

    }

    @Test
    public void shouldNotAddOToBoardWhenSpaceIsAlreadyTaken() {
        boardValues.set(0, " X ");
        gameBoard.setPlayerMove(" O ", " 1 ");
        assertFalse(boardValues.indexOf(" O ") == 0);
    }

    @Test
    public void shouldNotReturnWinningGameTrueWhenRandomThree() {
        Player player = mock(Player.class);
        when(player.formatSymbol()).thenReturn(" X ");
        boardValues.set(0, " X ");
        boardValues.set(3, " X ");
        boardValues.set(6, " X ");
        assertTrue(gameBoard.isWinningGameBoard(player));
    }

    @Test
    public void shouldReturnWinningGameTrueWhenTopThreeInARowHorizontal() {
        Player player = mock(Player.class);
        when(player.formatSymbol()).thenReturn(" X ");
        boardValues.set(0, " X ");
        boardValues.set(1, " X ");
        boardValues.set(2, " X ");
        assertTrue(gameBoard.isWinningGameBoard(player));
    }

    @Test
    public void shouldReturnWinningGameTrueWhenMiddleThreeInARowHorizontal() {
        Player player = mock(Player.class);
        when(player.formatSymbol()).thenReturn(" X ");
        boardValues.set(3, " X ");
        boardValues.set(4, " X ");
        boardValues.set(5, " X ");
        assertTrue(gameBoard.isWinningGameBoard(player));
    }
    @Test
    public void shouldReturnWinningGameTrueWhenBottomThreeInARowHorizontal() {
        Player player = mock(Player.class);
        when(player.formatSymbol()).thenReturn(" X ");
        boardValues.set(6, " X ");
        boardValues.set(7, " X ");
        boardValues.set(8, " X ");
        assertTrue(gameBoard.isWinningGameBoard(player));
    }
    @Test
    public void shouldReturnWinningGameTrueWhenLeftThreeInARowVertical() {
        Player player = mock(Player.class);
        when(player.formatSymbol()).thenReturn(" X ");
        boardValues.set(0, " X ");
        boardValues.set(3, " X ");
        boardValues.set(6, " X ");
        assertTrue(gameBoard.isWinningGameBoard(player));
    }
    @Test
    public void shouldReturnWinningGameTrueWhenMiddleThreeInARowVertical() {
        Player player = mock(Player.class);
        when(player.formatSymbol()).thenReturn(" X ");
        boardValues.set(1, " X ");
        boardValues.set(4, " X ");
        boardValues.set(7, " X ");
        assertTrue(gameBoard.isWinningGameBoard(player));
    }
    @Test
    public void shouldReturnWinningGameTrueWhenRightThreeInARowVertical() {
        Player player = mock(Player.class);
        when(player.formatSymbol()).thenReturn(" X ");
        boardValues.set(2, " X ");
        boardValues.set(5, " X ");
        boardValues.set(8, " X ");
        assertTrue(gameBoard.isWinningGameBoard(player));
    }
    @Test
    public void shouldReturnWinningGameTrueWhenLeftToRightDiagonal() {
        Player player = mock(Player.class);
        when(player.formatSymbol()).thenReturn(" X ");
        boardValues.set(0, " X ");
        boardValues.set(4, " X ");
        boardValues.set(8, " X ");
        assertTrue(gameBoard.isWinningGameBoard(player));
    }
    @Test
    public void shouldReturnWinningGameTrueWhenRightToLeftDiagonal() {
        Player player = mock(Player.class);
        when(player.formatSymbol()).thenReturn(" X ");
        boardValues.set(2, " X ");
        boardValues.set(4, " X ");
        boardValues.set(6, " X ");
        assertTrue(gameBoard.isWinningGameBoard(player));
    }
}