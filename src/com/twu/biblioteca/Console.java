package com.twu.biblioteca;

import java.util.*;

class Console {

    private ArrayList<Book> library;

    Console() {
        SetUpLibrary();
    }

    private void SetUpLibrary() {
        library = new ArrayList<Book>();
        library.add(new Book("The Color Purple", "Walker, Alice", "1982"));
        library.add(new Book("Emma", "Austen, Jane", "1815"));
        library.add(new Book("Schroder", "Gaige, Amity", "2013"));
        library.add(new Book("True Grit", "Portis, Charles", "1968"));
        library.add(new Book("Beloved", "Morrison, Toni", "1987"));
        library.add(new Book("Kiss of the Spider Woman", "Puig, Manuel", "1976"));
        library.add(new Book("Lord of the Flies", "Golding, William", "1954"));
        library.add(new Book("The White Tiger", "Adiga, Avarind", "2008"));
    }

    String getWelcomeMessage() {
        return "Hello!\nWelcome to Biblioteca.\nPlease type your commands below.";
    }

    String getMainMenu() {
        return "MAIN MENU:\nList Books";
    }

    String readMessage(String in) {
        if (in.equals("List Books")) {
            return listBooks();
        } else {
            return "Invalid menu option.  Try again.";
        }
    }

    private String listBooks() {
        // get maximum title and author length
        int maxTitleLength = 0;
        int maxAuthorLength = 0;
        for (Book activeBook : library) {
            if (activeBook.getTitle().length() > maxTitleLength) {
                maxTitleLength = activeBook.getTitle().length();
            }
            if (activeBook.getAuthor().length() > maxAuthorLength) {
                maxAuthorLength = activeBook.getAuthor().length();
            }
        }

        StringBuilder listOfBooks = getStringBuilderOfListOfBooks(maxTitleLength, maxAuthorLength);

        deleteTrailingNewlineCharacter(listOfBooks);

        return listOfBooks.toString();
    }

    private StringBuilder getStringBuilderOfListOfBooks(int maxTitleLength, int maxAuthorLength) {
        StringBuilder listOfBooks = new StringBuilder();
        for (Book activeBook : library) {
            String bookAsString = activeBook.toColumn(maxTitleLength, maxAuthorLength) + "\n";
            listOfBooks.append(bookAsString);
        }
        return listOfBooks;
    }

    private void deleteTrailingNewlineCharacter(StringBuilder listOfBooks) {
        listOfBooks.deleteCharAt(listOfBooks.length()-1);
    }

}
