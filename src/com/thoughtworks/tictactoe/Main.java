package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> boardValues = new ArrayList<>();
        Game game = new Game(new Player("X", new BufferedReader(new InputStreamReader(System.in)), System.out),
                            new Player("O", new BufferedReader(new InputStreamReader(System.in)), System.out),
                            new GameBoard(boardValues, System.out),
                            System.out);
        game.play();
    }
}