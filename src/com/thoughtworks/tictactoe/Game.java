package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Game {

    private PrintStream printStream;

    public Game(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void drawGameBoard() {
        printStream.println("   |   |   \n" +
                            "--- --- ---\n" +
                            "   |   |   \n" +
                            "--- --- ---\n" +
                            "   |   |   \n");
    }
}
