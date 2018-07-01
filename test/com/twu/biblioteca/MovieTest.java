package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void testToString() {
        Movie movie = new Movie("The Mooovie", "Cow, Arthur", "2014", "10");
        assertEquals("The Mooovie\tCow, Arthur\t2014\t10", movie.toString());
    }

    @Test
    public void testEquals() {
        Movie movie = new Movie("The Mooovie", "Cow, Arthur", "2014", "10");
        assertTrue(movie.equals(new Movie("The Mooovie", "Cow, Arthur", "2014", "10")));
    }
}
