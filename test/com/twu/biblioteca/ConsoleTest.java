package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ConsoleTest {

    @Test
    public void testWelcomeMessage() {
        Console console = new Console();
        assertEquals(console.getWelcomeMessage(), "Hello!\nWelcome to Biblioteca." +
                "\nPlease type your commands below.");
    }

    @Test
    public void testMainMenu() {
        Console console = new Console();
        assertEquals(console.getMainMenu(), "MAIN MENU:\nList Books");
    }

    @Test
    public void testReadMessageWithInvalidInput() {
        Console console = new Console();
        String message = "This is invalid";
        assertEquals(console.readMessage(message), "Invalid menu option.  Try again.");
    }

    @Test
    public void testReadMessageWithListBooks() {
        Console console = new Console();
        String message = "List Books";
        assertEquals(console.readMessage(message), "The Color Purple\nEmma\nSchroder\nTrue Grit" +
                "\nBeloved\nKiss of the Spider Woman\nLord of the Flies\nWhite Tiger");
    }
}

