package com.twu.biblioteca;

import java.util.*;

/*
This is the CONSOLE class.  Here, we read in any message typed in by the user,
perform appropriate operations, and then return a message indicating the result.
 */

class Console {

    private Library library;

    Console() {
        library = new Library();
    }

    String getWelcomeMessage() {
        return "Hello!\nWelcome to Biblioteca.\nPlease type your commands below.";
    }

    String getMainMenu() {
        return "MAIN MENU:\n" +
                "List Books\n" +
                "Quit";
    }

    String readMessage(String in) {

        if (in.equals("List Books")) {
            return listBooks();

        } else if (isACheckoutMessage(in)) {
            return performCheckOutSequence(in);

        }else if (in.equals("Quit")) {
            return quit();
        }
        else {
            return "Select a valid option!";
        }
    }

    private String performCheckOutSequence(String in) {
        Book toCheckout = parseCheckoutMessageAndReturnBook(in);
        toCheckout.checkOut();
        return toCheckout.getTitle() + " has been successfully checked out.";
    }

    private boolean isACheckoutMessage(String message) {
        String[] splitIntoWords = message.split(" ");
        return (splitIntoWords[0].equals("Checkout"));
    }

    private Book parseCheckoutMessageAndReturnBook(String message) {
        String bookTitle = parseCheckoutMessageAndReturnTitle(message);
        return library.getBookByTitle(bookTitle);
    }

    private String parseCheckoutMessageAndReturnTitle(String message) {
        int indexOfSpace = message.indexOf(' ');
        return message.substring(indexOfSpace + 1); // the book title
    }

    private String listBooks() {
        return library.getBookListInColumns();
    }

    String quit() {
       return "Goodbye!";
    }

}
