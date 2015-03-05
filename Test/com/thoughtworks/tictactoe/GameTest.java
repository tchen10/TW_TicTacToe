package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {

    @Test
    public void shouldDrawGameBoardWhenRun() {
        PrintStream printStream = mock(PrintStream.class);
        Game game = new Game(printStream);

        game.drawGameBoard();

        verify(printStream).println("   |   |   \n" +
                                    "--- --- ---\n" +
                                    "   |   |   \n" +
                                    "--- --- ---\n" +
                                    "   |   |   \n");
    }

}