package com.twu.biblioteca;

import java.util.*;

class Console {

    private Library library;

    Console() {
        library = new Library();
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
        return library.getBookListInColumns();
    }

}
