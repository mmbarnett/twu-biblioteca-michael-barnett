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
        assertEquals(console.getMainMenu(), "" +
                "\nMAIN MENU:\n" +
                "List Books\n" +
                "List Movies\n" +
                "Checkout <Title>\n" +
                "Return <Title>\n" +
                "Quit");
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

    @Test
    public void testReadMessageWithCheckout() {
        Console console = new Console();
        String message = "Checkout Emma";

        assertEquals("Emma has been successfully checked out.\nThank you! Enjoy the book.",
                console.readMessage(message));

    }

    @Test
    public void testCheckoutWhereBookTitleIsNotInLibrary() {
        Console console = new Console();
        String message = "Checkout Not A Real Book";

        assertEquals("That book is not available.", console.readMessage(message));
    }

    @Test
    public void testCheckoutWhereBookHasAlreadyBeenCheckedOut() {
        Console console = new Console();
        console.readMessage("Checkout Emma");
        assertEquals("That book is not available.", console.readMessage("Checkout Emma"));
    }

    @Test
    public void testThatCheckedOutBookDoesNotShowUpInListBooks() {
        Console console = new Console();
        console.readMessage("Checkout Emma");
        String columns = console.readMessage("List Books");
        assertEquals("The Color Purple           Walker, Alice      1982\n" +
                "" + // omitted because Emma has been checked out
                "Schroder                   Gaige, Amity       2013\n" +
                "True Grit                  Portis, Charles    1968\n" +
                "Beloved                    Morrison, Toni     1987\n" +
                "Kiss of the Spider Woman   Puig, Manuel       1976\n" +
                "Lord of the Flies          Golding, William   1954\n" +
                "The White Tiger            Adiga, Avarind     2008", columns);

    }

    @Test
    public void testReadMessageWithReturn() {
        Console console = new Console();
        console.readMessage("Checkout Emma");

        assertEquals("Emma has been successfully returned.\nThank you for returning the book.",
                console.readMessage("Return Emma"));
    }

    @Test
    public void testThatAReturnedBookDoesShowUpInListBooks() {
        Console console = new Console();
        console.readMessage("Checkout Emma");
        console.readMessage("Checkout Kiss of the Spider Woman");
        console.readMessage("Return Emma");
        String columns = console.readMessage("List Books");

        assertEquals("The Color Purple           Walker, Alice      1982\n" +
                "Emma                       Austen, Jane       1815\n" +
                "Schroder                   Gaige, Amity       2013\n" +
                "True Grit                  Portis, Charles    1968\n" +
                "Beloved                    Morrison, Toni     1987\n" +
                "" + // omitted because checked out"
                "Lord of the Flies          Golding, William   1954\n" +
                "The White Tiger            Adiga, Avarind     2008", columns);
    }

    @Test
    public void testInvalidReturn() {
        Console console = new Console();

        // want to check for an invalid return in two cases:
        // 1) The book isn't in the library
        assertEquals("This is not a valid book to return.",
                console.readMessage("Return A Book Not in the Library"));

        // 2) The book isn't checked out
        assertEquals("This is not a valid book to return.", console.readMessage("Return Emma"));

    }

    @Test
    public void testListMovies() {
        Console console = new Console();
        String columns = console.readMessage("List Movies");

        assertEquals("The Mooovie   2014   Cow, Arthur       10\n" +
                        "Star Warts    1998   Gothel, Mother    Unrated\n" +
                        "O Rosalind    1622   Montague, Romeo   3", columns);
    }

    @Test
    public void testCheckOutMovie() {
        Console console = new Console();
        console.readMessage("Checkout Star Warts");
        assertEquals("The Mooovie   2014   Cow, Arthur       10\n" +
                "" + // Star Warts has been checked out
                "O Rosalind    1622   Montague, Romeo   3",
                console.readMessage("List Movies"));
    }
}

