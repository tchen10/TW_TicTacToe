package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.List;

public class GameBoard {
    private List<String> boardValues;
    private PrintStream printStream;

    public GameBoard(List<String> boardValues, PrintStream printStream) {
        this.boardValues = boardValues;
        this.printStream = printStream;
        setInitialBoardValues();
    }

    public void checkPlayerMove(Player player) {
        String playerMove = player.getFormattedPlayerMove();
        if (isValidMove(playerMove)) {
            makePlayerMove(player, playerMove);
        } else {
            printStream.println("Location already taken");
            checkPlayerMove(player);
        }
    }

    public boolean isWinningGame(Player player) {
        String playerSymbol = player.getFormattedPlayerSymbol();
        return checkWinningLine(playerSymbol, 0, 1, 2) ||
                checkWinningLine(playerSymbol, 3, 4, 5) ||
                checkWinningLine(playerSymbol, 6, 7, 8) ||
                checkWinningLine(playerSymbol, 0, 3, 6) ||
                checkWinningLine(playerSymbol, 1, 4, 7) ||
                checkWinningLine(playerSymbol, 2, 5, 8) ||
                checkWinningLine(playerSymbol, 0, 4, 8) ||
                checkWinningLine(playerSymbol, 2, 4, 6);
    }

    private boolean checkWinningLine(String playerMove, int num1, int num2, int num3) {
        String[] winningLine = new String[3];
        winningLine[0] = boardValues.get(num1);
        winningLine[1] = boardValues.get(num2);
        winningLine[2] = boardValues.get(num3);
        int moves = 0;
        for (String boardValue : winningLine) {
            if (boardValue.equals(playerMove)) {
                moves++;
            }
        }
        return moves == 3;
    }


    public void print() {
        printOneRow(0, 1, 2);
        printStream.println("-----------");
        printOneRow(3, 4, 5);
        printStream.println("-----------");
        printOneRow(6, 7, 8);
    }

    private void makePlayerMove(Player player, String playerMove) {
        int position = boardValues.indexOf(playerMove);
        boardValues.set(position, player.getFormattedPlayerSymbol());
    }

    private boolean isValidMove(String playerMove) {
        return boardValues.contains(playerMove);
    }

    private void printOneRow(int left, int middle, int right) {
        printStream.printf(boardValues.get(left));
        printStream.printf("|");
        printStream.printf(boardValues.get(middle));
        printStream.printf("|");
        printStream.printf(boardValues.get(right));
        printStream.printf("\n");
    }

    private void setInitialBoardValues() {
        boardValues.add(" 1 ");
        boardValues.add(" 2 ");
        boardValues.add(" 3 ");
        boardValues.add(" 4 ");
        boardValues.add(" 5 ");
        boardValues.add(" 6 ");
        boardValues.add(" 7 ");
        boardValues.add(" 8 ");
        boardValues.add(" 9 ");
    }
}
