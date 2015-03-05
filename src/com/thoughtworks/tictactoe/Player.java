package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;

public class Player {
    private BufferedReader reader;
    private String playerXO;

    public Player(String playerXO, BufferedReader reader) {
        this.playerXO = playerXO;
        this.reader = reader;
    }

    public String getPlayerMove() {
        System.out.println("Enter a number between 1-9:");
        String playerMove = "";
        try {
            playerMove = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return playerMove;
    }
    

}
