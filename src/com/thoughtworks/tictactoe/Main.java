package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> boardValues = new ArrayList<>();
        PrintStream out = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Game game = new Game(new Player("X", reader),
                            new Player("O", reader),
                            new GameBoard(boardValues, out),
                            out);
        game.play();
    }
}