package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.List;

public class Game {

    private Player player1;
    private Player player2;
    private PrintStream printStream;
    private GameBoard gameBoard;


    public Game(Player player1, Player player2, GameBoard gameBoard, PrintStream printStream) {
        this.player1 = player1;
        this.player2 = player2;
        this.printStream = printStream;
        this.gameBoard = gameBoard;
    }

    public void startPlaying() {
        gameBoard.print();
        playNextTurn(player1);
        playNextTurn(player2);
    }


    public void playNextTurn(Player player) {
        gameBoard.setPlayerMove(player);
        gameBoard.print();
    }

}
