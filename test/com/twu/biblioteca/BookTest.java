package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void testToString() {
        Book book = new Book("Emma", "Austen, Jane", "1815");
        assertEquals(book.toString(), "Emma\tAusten, Jane\t1815");
    }

    @Test
    public void testToColumnWithCheckedOutBooks() {
        Book book = new Book("Emma", "Austen, Jane", "1815");
        assertEquals("Emma   Austen, Jane   1815", book.toColumn(4, 12));
        book.checkOut();
        assertEquals("", book.toColumn(4, 12));
    }

    @Test
    public void testEquals() {
        Book book = new Book("Emma", "Austen, Jane", "1815");
//        assertEquals(book, new Book("Emma", "Austen, Jane", "1815"));
//        assertNotEquals(book, new Book("Not Emma", "Not Austen, Jane", "2015"));
        assertTrue(book.equals(new Book("Emma", "Austen, Jane", "1815")));
    }
}
