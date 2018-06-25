package com.twu.biblioteca;

import java.util.*;

class Console {

    private ArrayList<String> library;

    Console() {
        SetUpLibrary();
    }

    private void SetUpLibrary() {
        library = new ArrayList<String>();
        library.add("The Color Purple");
        library.add("Emma");
        library.add("Schroder");
        library.add("True Grit");
        library.add("Beloved");
        library.add("Kiss of the Spider Woman");
        library.add("Lord of the Flies");
        library.add("White Tiger");
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
        StringBuilder listOfBooks = new StringBuilder(library.get(0));
        for (int i = 1; i < library.size(); i++) {
            String nextBook = "\n" + library.get(i);
            listOfBooks.append(nextBook);
        }
        return listOfBooks.toString();
    }

}
