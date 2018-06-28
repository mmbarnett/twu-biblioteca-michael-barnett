package com.twu.biblioteca;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import java.io.*;
import java.util.*;

public class BibliotecaAppTest {

    // Bunch of stuff here to help me read what is coming out of System.out.println()
    // Found this implementation on the internet.

    // My understanding is that I can now use outContent.toString() to get a String
    // representation of whatever is "printed" by BibliotecaApp

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testPrintWelcomeAndMainMenu() {
        Console console = new Console();
        BibliotecaApp.welcome(console);
        assertEquals("Hello!\nWelcome to Biblioteca.\nPlease type your commands below.\n\n" +
                "MAIN MENU:\n" +
                "List Books\n"+
                "Checkout <Title>\n"+
                "Return <Title>\n"+
                "Quit\n", outContent.toString());
    }

    @Test
    public void testPassesCommandAndPrintsResponse() {

        String message = "List Books\n";
        byte[] bytes = message.getBytes();

        ByteArrayInputStream inContent = new ByteArrayInputStream(bytes);

        Console console = new Console();

        BibliotecaApp.listen(inContent, console);

        assertEquals(
                "The Color Purple           Walker, Alice      1982\n" +
                "Emma                       Austen, Jane       1815\n" +
                "Schroder                   Gaige, Amity       2013\n" +
                "True Grit                  Portis, Charles    1968\n" +
                "Beloved                    Morrison, Toni     1987\n" +
                "Kiss of the Spider Woman   Puig, Manuel       1976\n" +
                "Lord of the Flies          Golding, William   1954\n" +
                "The White Tiger            Adiga, Avarind     2008\n", outContent.toString());
    }

}
