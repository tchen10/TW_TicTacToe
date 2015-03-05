package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(new Player("X", new BufferedReader(new InputStreamReader(System.in))),
                            new Player("O", new BufferedReader(new InputStreamReader(System.in))),
                            System.out);
        game.startPlaying();
    }
}