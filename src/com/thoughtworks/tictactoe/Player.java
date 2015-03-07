package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;

public class Player {
    private BufferedReader reader;
    private String playerSymbol;

    public Player(String playerSymbol, BufferedReader reader) {
        this.playerSymbol = playerSymbol;
        this.reader = reader;
    }

    public String makeMove() {
        String playerMove = "";
        try {
            playerMove = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return " " + playerMove + " ";
    }

    public String formatSymbol() {
        return " " + playerSymbol + " ";
    }

}
