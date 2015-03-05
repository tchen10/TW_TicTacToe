package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player1;
    private Player player2;
    private PrintStream printStream;
    private List<String> row1 = new ArrayList<>();
    private List<String> row2 = new ArrayList<>();
    private List<String> row3 = new ArrayList<>();

    public Game(Player player1, Player player2, PrintStream printStream) {
        this.player1 = player1;
        this.player2 = player2;
        this.printStream = printStream;
    }

    public void startPlaying() {
        setInitialGameBoard();
        drawOngoingGameBoard(player1);
        drawOngoingGameBoard(player2);
    }

    public void setInitialGameBoard() {
        setInitialRowValues(row1, "1", "2", "3");
        setInitialRowValues(row2, "4", "5", "6");
        setInitialRowValues(row3, "7", "8", "9");
        drawGameBoard();
    }

    public void drawOngoingGameBoard(Player player) {
        String playerMove = " " + player.getPlayerMove() + " ";
        setPlayerMove(player, playerMove);
        drawGameBoard();
    }

    private void setPlayerMove(Player player, String playerMove) {
        if (!isValidPlayerMove(row1, playerMove, player) &&
                !isValidPlayerMove(row2, playerMove, player) &&
                !isValidPlayerMove(row3, playerMove, player)) {
            printStream.println("Location already taken");
        }
    }

    private boolean isValidPlayerMove(List<String> row, String playerMove, Player player) {
        boolean isValidMove = false;
        int position = row.indexOf(playerMove);
        if (row.contains(playerMove)) {
            row.set(position, player.getFormattedPlayerXO());
            isValidMove = true;
        }
        return isValidMove;
    }

    private void setInitialRowValues(List<String> row, String space1, String space2, String space3) {
        row.add(" " + space1 + " ");
        row.add("|");
        row.add(" " + space2 + " ");
        row.add("|");
        row.add(" " + space3 + " ");
    }

    private void drawGameBoard() {
        drawOneRowOfGameBoard(row1);
        printStream.println("-----------");
        drawOneRowOfGameBoard(row2);
        printStream.println("-----------");
        drawOneRowOfGameBoard(row3);
    }

    private void drawOneRowOfGameBoard(List<String> row) {
        for (String space : row) {
            printStream.printf(space);
        }
        printStream.printf("\n");
    }
}
