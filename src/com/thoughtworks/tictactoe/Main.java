package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> gameBoard = new ArrayList<>();
        Game game = new Game(new Player("X", new BufferedReader(new InputStreamReader(System.in)), System.out),
                            new Player("O", new BufferedReader(new InputStreamReader(System.in)), System.out),
                            gameBoard,
                            System.out);
        game.startPlaying();
    }
}