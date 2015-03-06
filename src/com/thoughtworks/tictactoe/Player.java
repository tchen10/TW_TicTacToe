package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {
    private BufferedReader reader;
    private String playerSymbol;
    private PrintStream printStream;

    public Player(String playerSymbol, BufferedReader reader, PrintStream printStream) {
        this.playerSymbol = playerSymbol;
        this.reader = reader;
        this.printStream = printStream;
    }

    public String getFormattedPlayerMove() {
        printStream.println("Enter a number between 1-9:");
        String playerMove = "";
        try {
            playerMove = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return " " + playerMove + " ";
    }

    public String getFormattedPlayerSymbol() {
        return " " + playerSymbol + " ";
    }

}
