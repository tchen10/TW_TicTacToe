package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Player player1;
    private Player player2;
    private PrintStream printStream;
    private List<String> gameBoard;


    public Game(Player player1, Player player2, List<String> gameBoard, PrintStream printStream) {
        this.player1 = player1;
        this.player2 = player2;
        this.printStream = printStream;
        this.gameBoard = gameBoard;
    }

    public void startPlaying() {
        setInitialGameBoard();
        drawOngoingGameBoard(player1);
        drawOngoingGameBoard(player2);
    }

    public void setInitialGameBoard() {
        setInitialRowValues(gameBoard);
        drawGameBoard();
    }

    public void drawOngoingGameBoard(Player player) {
        String playerMove = " " + player.getPlayerMove() + " ";
        setPlayerMove(player, playerMove);
        drawGameBoard();
    }

    private void setPlayerMove(Player player, String playerMove) {
        if (!isValidPlayerMove(gameBoard, playerMove, player)) {
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

    private void setInitialRowValues(List<String> row) {
        row.add(" 1 ");
        row.add("|");
        row.add(" 2 ");
        row.add("|");
        row.add(" 3 ");
        row.add("|");
        row.add(" 4 ");
        row.add("|");
        row.add(" 5 ");
        row.add("|");
        row.add(" 6 ");
        row.add("|");
        row.add(" 7 ");
        row.add("|");
        row.add(" 8 ");
        row.add("|");
        row.add(" 9 ");
    }

    private void drawGameBoard() {
        drawOneRowOfGameBoard(gameBoard, 0, 5);
        printStream.println("-----------");
        drawOneRowOfGameBoard(gameBoard, 6, 11);
        printStream.println("-----------");
        drawOneRowOfGameBoard(gameBoard, 12, 17);
    }

    private void drawOneRowOfGameBoard(List<String> row, int from, int to) {
        for (String space : row.subList(from,to)) {
            printStream.printf(space);
        }
        printStream.printf("\n");
    }
}
