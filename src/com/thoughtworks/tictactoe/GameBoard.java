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

    public boolean setPlayerMove(String playerSymbol, String playerMove) {
        if (isValidPlayerMove(playerMove)) {
            int position = boardValues.indexOf(playerMove);
            boardValues.set(position, playerSymbol);
            print();
            return true;
        }
        return false;
    }

    public boolean isWinningGameBoard(Player player) {
        String playerSymbol = player.formatSymbol();
        return checkWinningLine(playerSymbol, 0, 1, 2) ||
                checkWinningLine(playerSymbol, 3, 4, 5) ||
                checkWinningLine(playerSymbol, 6, 7, 8) ||
                checkWinningLine(playerSymbol, 0, 3, 6) ||
                checkWinningLine(playerSymbol, 1, 4, 7) ||
                checkWinningLine(playerSymbol, 2, 5, 8) ||
                checkWinningLine(playerSymbol, 0, 4, 8) ||
                checkWinningLine(playerSymbol, 2, 4, 6);
    }

    public void print() {
        printOneRow(0, 1, 2);
        printStream.println("-----------");
        printOneRow(3, 4, 5);
        printStream.println("-----------");
        printOneRow(6, 7, 8);
    }

    private boolean isValidPlayerMove(String playerMove) {
        return boardValues.contains(playerMove);
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

    private void printOneRow(int left, int middle, int right) {
        printStream.print(boardValues.get(left) + "|" + boardValues.get(middle) + "|" + boardValues.get(right) + "\n");
    }

    private void setInitialBoardValues() {
        for (int i = 1; i < 10; i++) {
            boardValues.add(" " + i + " ");
        }
    }
}
