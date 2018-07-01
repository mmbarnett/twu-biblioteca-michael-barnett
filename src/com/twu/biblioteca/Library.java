package com.twu.biblioteca;

import java.util.*;

/*
The LIBRARY keeps track of all the books in the library.
Could conceivably be replaced by a database, but this will suffice as well.
There is no way to add or remove books from the library.  You may only check in and check out books.
 */

public class Library {

    private ArrayList<Resource> bookList;
    private ArrayList<Resource> movieList;

    public Library() {
        bookList = new ArrayList<Resource>();
        movieList = new ArrayList<Resource>();
        setUpLibrary();
    }

    private void setUpLibrary() {
        bookList.add(new Book("The Color Purple", "Walker, Alice", "1982"));
        bookList.add(new Book("Emma", "Austen, Jane", "1815"));
        bookList.add(new Book("Schroder", "Gaige, Amity", "2013"));
        bookList.add(new Book("True Grit", "Portis, Charles", "1968"));
        bookList.add(new Book("Beloved", "Morrison, Toni", "1987"));
        bookList.add(new Book("Kiss of the Spider Woman", "Puig, Manuel", "1976"));
        bookList.add(new Book("Lord of the Flies", "Golding, William", "1954"));
        bookList.add(new Book("The White Tiger", "Adiga, Avarind", "2008"));

        movieList.add(new Movie("The Mooovie", "2014", "Cow, Arthur", "10"));
        movieList.add(new Movie("Star Warts", "1998", "Gothel, Mother", "Unrated"));
        movieList.add(new Movie("O Rosalind", "1622", "Montague, Romeo", "3"));
    }

    public boolean containsTitle(String title) {
        for (Resource book : bookList) {
            if (book.getTitle().equals(title)) {
                return true;
            }
        }

        for (Resource movie : movieList) {
            if (movie.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public Resource getResourceByTitle(String title) {
        for (Resource book : bookList) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        for (Resource movie : movieList) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        throw new IllegalArgumentException("Resource not found.");
    }

    public String getResourceListInColumns(String mode) {
        // mode operates as follows:
        // if mode == "book", prints book list
        // if mode == "movie", prints movie list
        // if mode == "all", prints all resources

        ArrayList<Resource> resourceList = new ArrayList<Resource>();

        // set up resourceList
        if (mode.equals("book")) {
            resourceList = bookList;
        } else if (mode.equals("movie")) {
            resourceList = movieList;
        } else if (mode.equals("all")) {
            resourceList.addAll(bookList);
            resourceList.addAll(movieList);
        }

        StringBuilder builder = getStringBuilderOfListOfResources(resourceList);

        deleteTrailingNewlineCharacter(builder);

        return builder.toString();
    }

    // gets the maximum length of title or author in library
    private int getMaxFieldLength(boolean isTitle, ArrayList<Resource> resourceList) {
        int maxLength = 0;
        for (Resource active : resourceList) {

            int length;
            if (isTitle)
                length = active.getTitle().length();
            else // looking for author
                length = active.getCreator().length();

            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    private StringBuilder getStringBuilderOfListOfResources(ArrayList<Resource> resourceList) {

        int maxTitleLength = getMaxFieldLength(true, resourceList);
        int maxAuthorLength = getMaxFieldLength(false, resourceList);

        StringBuilder builder = new StringBuilder();
        for (Resource active : resourceList) {
            if (active.isCheckedIn()) {
                String resourceAsString = active.toColumn(maxTitleLength, maxAuthorLength) + "\n";
                builder.append(resourceAsString);
            }
        }
        return builder;
    }

    private void deleteTrailingNewlineCharacter(StringBuilder builder) {
        builder.deleteCharAt(builder.length()-1);
    }

    public ArrayList<Resource> getBookList() {
        return bookList;
    }
}
