package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConsoleTest {

    @Test
    public void testWelcomeMessage() {
        Console console = new Console();
        assertEquals(console.getWelcomeMessage(), "Hello! \n Welcome to Biblioteca. " +
                "\n Please type your commands below.");
    }

    @Test
    public void testMainMenu() {
        Console console = new Console();
        assertEquals(console.getMainMenu(), "MAIN MENU: \n List Books");
    }

    @Test
    public void testReadInvalidInput() {
        Console console = new Console();
        String message = "This is invalid";
        assertEquals(console.readMessage(message), "Invalid menu option.  Try again.");
    }
}

