package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void testGetBookListInColumns() {
        Library library = new Library();
        assertEquals("The Color Purple           Walker, Alice      1982\n" +
                        "Emma                       Austen, Jane       1815\n" +
                        "Schroder                   Gaige, Amity       2013\n" +
                        "True Grit                  Portis, Charles    1968\n" +
                        "Beloved                    Morrison, Toni     1987\n" +
                        "Kiss of the Spider Woman   Puig, Manuel       1976\n" +
                        "Lord of the Flies          Golding, William   1954\n" +
                        "The White Tiger            Adiga, Avarind     2008",
                library.getResourceListInColumns("book"));
    }

    @Test
    public void testGetBookByTitle() {
        Library library = new Library();
        Book book = library.getResourceByTitle("Emma").toBook();
        assertTrue(book.equals(
                new Book("Emma", "Austen, Jane", "1815")));

    }

    @Test
    public void testGetResourceListInColumnsWithMovieMode() {
        Library library = new Library();
        assertEquals(
                "The Mooovie   2014   Cow, Arthur       10\n" +
                        "Star Warts    1998   Gothel, Mother    Unrated\n" +
                        "O Rosalind    1622   Montague, Romeo   3",
                library.getResourceListInColumns("movie"));

    }

}
