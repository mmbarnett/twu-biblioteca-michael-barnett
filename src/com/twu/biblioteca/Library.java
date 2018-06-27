package com.twu.biblioteca;

import java.util.*;

/*
The LIBRARY keeps track of all the books in the library.
Could conceivably be replaced by a database, but this will suffice as well.
There is no way to add or remove books from the library.  You may only check in and check out books.
 */

public class Library {

    private ArrayList<Book> bookList;

    public Library() {
        bookList = new ArrayList<Book>();
        setUpLibrary();
    }

    private void setUpLibrary() {
        bookList = new ArrayList<Book>();
        bookList.add(new Book("The Color Purple", "Walker, Alice", "1982"));
        bookList.add(new Book("Emma", "Austen, Jane", "1815"));
        bookList.add(new Book("Schroder", "Gaige, Amity", "2013"));
        bookList.add(new Book("True Grit", "Portis, Charles", "1968"));
        bookList.add(new Book("Beloved", "Morrison, Toni", "1987"));
        bookList.add(new Book("Kiss of the Spider Woman", "Puig, Manuel", "1976"));
        bookList.add(new Book("Lord of the Flies", "Golding, William", "1954"));
        bookList.add(new Book("The White Tiger", "Adiga, Avarind", "2008"));
    }

    public Book getBookByTitle(String title) {
        for (Book book : bookList) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
//        throw new RuntimeException("Book not found.");
    }

    public String getBookListInColumns() {

        StringBuilder builder = getStringBuilderOfListOfBooks(getMaxFieldLength(true),
                getMaxFieldLength(false));

        deleteTrailingNewlineCharacter(builder);

        return builder.toString();
    }

    // gets the maximum length of title or author in library
    private int getMaxFieldLength(boolean isTitle) {
        int maxLength = 0;
        for (Book activeBook : bookList) {

            int length;
            if (isTitle)
                length = activeBook.getTitle().length();
            else // looking for author
                length = activeBook.getAuthor().length();

            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    private StringBuilder getStringBuilderOfListOfBooks(int maxTitleLength, int maxAuthorLength) {
        StringBuilder builder = new StringBuilder();
        for (Book activeBook : bookList) {
            if (activeBook.isCheckedIn()) {
                String bookAsString = activeBook.toColumn(maxTitleLength, maxAuthorLength) + "\n";
                builder.append(bookAsString);
            }
        }
        return builder;
    }

    private void deleteTrailingNewlineCharacter(StringBuilder builder) {
        builder.deleteCharAt(builder.length()-1);
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }
}
