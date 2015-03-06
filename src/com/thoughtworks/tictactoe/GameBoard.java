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

    public boolean isWinningGame() {
        return true;
    }

    public void print() {
        printOneRow(boardValues, 0, 1, 2);
        printStream.println("-----------");
        printOneRow(boardValues, 3, 4, 5);
        printStream.println("-----------");
        printOneRow(boardValues, 6, 7, 8);
    }

    private void makePlayerMove(Player player, String playerMove) {
        int position = boardValues.indexOf(playerMove);
        boardValues.set(position, player.getFormattedPlayerSymbol());
    }

    private boolean isValidMove(String playerMove) {
        if (boardValues.contains(playerMove)) {
            return true;
        }
        return false;
    }

    private void printOneRow(List<String> row, int left, int middle, int right) {
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
