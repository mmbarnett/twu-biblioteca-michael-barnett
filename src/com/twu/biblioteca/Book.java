package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private String year;

    Book(String titleArg, String authorArg, String yearArg) {
        title = titleArg;
        author = authorArg;
        year = yearArg;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

    public String toString() {
        return title + "\t" + author + "\t" + year;
    }

    String toColumn(int titleLength, int authorLength) {
        StringBuilder row = new StringBuilder(title);
        while (row.length() < titleLength + 3) { // need space even with longest title
            row.append(" ");
        }

        row.append(author);
        while (row.length() < titleLength + authorLength + 6) {
            row.append(" ");
        }

        row.append(year);

        return row.toString();
    }


}
