package com.twu.biblioteca;

/*
This is a BOOK.  It keeps track of its title, author, year published, and whether or not
it is currently checked in.  It also returns itself as a string in several aesthetic ways.
 */

public class Book extends Resource {

    public Book(String titleArg, String authorArg, String yearArg) {
        title = titleArg;
        creator = authorArg;
        year = yearArg;
        isCheckedIn = true;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getCreator() {
        return getAuthor();
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public String getAuthor() {
        return creator;
    }

    public String toString() {
        return title + "\t" + creator + "\t" + year;
    }

    public String toColumn(int titleLength, int authorLength) {
        if (!isCheckedIn) {
            return "";
        }

        StringBuilder row = new StringBuilder(title);
        while (row.length() < titleLength + 3) { // need space even with longest title
            row.append(" ");
        }

        row.append(creator);
        while (row.length() < titleLength + authorLength + 6) {
            row.append(" ");
        }

        row.append(year);

        return row.toString();
    }

    public boolean equals(Book other) {
        return other.toString().equals(toString());
    }

}
