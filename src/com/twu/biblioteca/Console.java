package com.twu.biblioteca;

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
        return "\nMAIN MENU:\n" +
                "List Books\n" +
                "Checkout <Title>\n" +
                "Return <Title>\n" +
                "Quit";
    }

    String readMessage(String in) {

        if (in.equals("List Books")) {
            return listBooks();

        } else if (isACheckoutMessage(in)) {
            return performCheckOutSequence(in);

        } else if (isAReturnMessage(in)) {
            return performReturnSequence(in);

        } else if (in.equals("Quit")) {
            return quit();
        }

        else {
            return "Select a valid option!";
        }
    }

    private boolean isAReturnMessage(String message) {
        String[] splitIntoWords = message.split(" ");
        return (splitIntoWords[0].equals("Return"));
    }

    private String performReturnSequence(String in) {
        String bookTitle = getAllWordsExceptFirstWord(in); //AH CHANGE THIS
        if (isAValidReturn(bookTitle)) {
            Book toReturn = library.getBookByTitle(bookTitle);
            toReturn.returnBook();
            return toReturn.getTitle() + " has been successfully returned.\nThank you for returning the book.";
        }
        else {
            return "This is not a valid book to return.";
        }
    }

    private boolean bookWithThisTitleIsCheckedOut(String title) {
        Book book = library.getBookByTitle(title);
        return !book.isCheckedIn();
    }

    private String performCheckOutSequence(String in) {
        String bookTitle = getAllWordsExceptFirstWord(in);
        if (isAValidCheckout(bookTitle)) {
            Book toCheckout = library.getBookByTitle(bookTitle);
            toCheckout.checkOut();
            return toCheckout.getTitle() + " has been successfully checked out.\nThank you! Enjoy the book.";
        }
        else {
            return "That book is not available.";
        }
    }

    private boolean isAValidReturn(String title) {
        return library.containsTitle(title) && bookWithThisTitleIsCheckedOut(title);
    }

    private boolean isAValidCheckout(String title) {
        return library.containsTitle(title) && !bookWithThisTitleIsCheckedOut(title);
    }

    private boolean isACheckoutMessage(String message) {
        String[] splitIntoWords = message.split(" ");
        return (splitIntoWords[0].equals("Checkout"));
    }

    private Book parseCheckoutMessageAndReturnBook(String message) {
        String bookTitle = getAllWordsExceptFirstWord(message);
        return library.getBookByTitle(bookTitle);
    }

    private String getAllWordsExceptFirstWord(String message) {
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
