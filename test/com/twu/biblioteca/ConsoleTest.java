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
        assertEquals(console.getMainMenu(), "MAIN MENU:\nList Books\nQuit");
    }

    @Test
    public void testReadMessageWithInvalidInput() {
        Console console = new Console();
        String message = "This is invalid";
        assertEquals(console.readMessage(message), "Select a valid option!");
    }

    @Test
    public void testReadMessageWithListBooks() {
        Console console = new Console();
        String message = "List Books";
        assertEquals(console.readMessage(message),
                "The Color Purple           Walker, Alice      1982\n" +
                        "Emma                       Austen, Jane       1815\n" +
                        "Schroder                   Gaige, Amity       2013\n" +
                        "True Grit                  Portis, Charles    1968\n" +
                        "Beloved                    Morrison, Toni     1987\n" +
                        "Kiss of the Spider Woman   Puig, Manuel       1976\n" +
                        "Lord of the Flies          Golding, William   1954\n" +
                        "The White Tiger            Adiga, Avarind     2008");
    }

    @Test
    public void testQuit() {
        Console console = new Console();
        String message = "Quit";
        assertEquals("Goodbye!", console.quit());
    }

}

