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
        return "MAIN MENU:\n" +
                "List Books\n" +
                "Quit";
    }

    String readMessage(String in) {
        if (in.equals("List Books")) {
            return listBooks();
        } else if (in.equals("Quit")) {
            return quit();
        }
        else {
            return "Select a valid option!";
        }
    }

    private String listBooks() {
        return library.getBookListInColumns();
    }

    String quit() {
       return "Goodbye!";
    }

}
