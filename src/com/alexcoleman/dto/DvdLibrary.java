package com.alexcoleman.dto;

public class DvdLibrary {
    private String title;
    private String releaseYear;
    private String mppaRating;
    private String directorName;
    private String studio;
    private String userRating;

    public DvdLibrary(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getMppaRating() {
        return mppaRating;
    }

    public void setMppaRating(String mppaRating) {
        this.mppaRating = mppaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
