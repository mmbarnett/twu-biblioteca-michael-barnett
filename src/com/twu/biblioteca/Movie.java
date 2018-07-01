package com.twu.biblioteca;

public class Movie extends Resource {

    private String rating;

    public Movie(String titleArg, String yearArg, String directorArg, String ratingArg) {
        title = titleArg;
        year = yearArg;
        creator = directorArg;
        rating = ratingArg;
    }

    public String getDirector() {
        return creator;
    }

    public String getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getCreator() {
        return getDirector();
    }

    public String toColumn(int titleLength, int directorLength) {

        StringBuilder row = new StringBuilder(title);
        while (row.length() < titleLength + 3) { // need spaces to be even with longest title
            row.append(" ");
        }

        row.append(year + "   ");

        row.append(creator);
        while (row.length() < titleLength + directorLength + 9 + 4) { // 4 chars for the year
            row.append(" ");
        }

        row.append(rating);

        return row.toString();

    }


}
