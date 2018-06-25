package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void testToString() {
        Book book = new Book("Emma", "Austen, Jane", "1815");
        assertEquals(book.toString(), "Emma\tAusten, Jane\t1815");
    }
}
