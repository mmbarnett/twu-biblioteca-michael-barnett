package com.twu.biblioteca;

public abstract class Resource {

    protected String title;
    protected String year;
    protected String creator;
    protected boolean isCheckedIn;

    public String getTitle() {
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public String getYear() {
        return year;
    }

    public abstract String toColumn(int titleLength, int creatorLength);
    public abstract String toString();

    public boolean equals(Resource other) {
        return toString().equals(other.toString());
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void checkOut() {
        isCheckedIn = false;
    }

    public void checkIn() {
        isCheckedIn = true;
    }

    public Book toBook() {
        if (this instanceof Book) {
            return (Book) this;
        } else {
            throw new IllegalArgumentException("toBook called on a non-book object");
        }
    }

    public Movie toMovie() {
        if (this instanceof Movie) {
            return (Movie) this;
        } else {
            throw new IllegalArgumentException("toMovie called on a non-Movie object");
        }
    }


}
