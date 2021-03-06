package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Game {

    private Player player1;
    private Player player2;
    private PrintStream printStream;
    private GameBoard gameBoard;
    private int turnCount;


    public Game(Player player1, Player player2, GameBoard gameBoard, PrintStream printStream) {
        this.player1 = player1;
        this.player2 = player2;
        this.printStream = printStream;
        this.gameBoard = gameBoard;
    }

    public void play() {
        turnCount = 0;
        gameBoard.print();
        while (turnCount < 9) {
            takeAlternateTurns(turnCount);
            turnCount++;
        }
        if (turnCount == 9 ) {
            printStream.println("Game is a draw");
        }
    }

    private void takeAlternateTurns(int turnCount) {
        if (turnCount % 2 == 0) {
            playTurn(player1);
        } else {
            playTurn(player2);
        }
    }

    public void playTurn(Player player) {
        printStream.println("Enter a number between 1-9:");
        String playerMove = player.makeMove();
        if (gameBoard.setPlayerMove(player.formatSymbol(), playerMove)) {
            winGame(player);
        } else {
            printStream.println("Location already taken");
            playTurn(player);
        }
    }


    private void winGame(Player player) {
        if (gameBoard.isWinningGameBoard(player)) {
            printStream.println("Player" + player.formatSymbol() + "wins!");
            turnCount = 10;
        }
    }

}
