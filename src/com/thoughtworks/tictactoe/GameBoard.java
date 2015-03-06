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

    public void setPlayerMove(Player player) {
        String playerMove = " " + player.getPlayerMove() + " ";
        int position = boardValues.indexOf(playerMove);
        if (boardValues.contains(playerMove)) {
            boardValues.set(position, player.getFormattedPlayerSymbol());
        } else {
            printStream.println("Location already taken");
            player.getPlayerMove();
        }
    }

    public void print() {
        printOneRow(boardValues, 0, 5);
        printStream.println("-----------");
        printOneRow(boardValues, 5, 10);
        printStream.println("-----------");
        printOneRow(boardValues, 10, 15);
    }

    private void printOneRow(List<String> row, int from, int to) {
        for (String space : row.subList(from,to)) {
            printStream.printf(space);
        }
        printStream.printf("\n");
    }

    private void setInitialBoardValues() {
        boardValues.add(" 1 ");
        boardValues.add("|");
        boardValues.add(" 2 ");
        boardValues.add("|");
        boardValues.add(" 3 ");
        boardValues.add(" 4 ");
        boardValues.add("|");
        boardValues.add(" 5 ");
        boardValues.add("|");
        boardValues.add(" 6 ");
        boardValues.add(" 7 ");
        boardValues.add("|");
        boardValues.add(" 8 ");
        boardValues.add("|");
        boardValues.add(" 9 ");
    }
}
