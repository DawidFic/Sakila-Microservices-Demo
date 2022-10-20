package com.Sakila_Microservices;

import javax.persistence.*;

@Entity
@Table(name="Film")

public class Film {
    //Attributes//
    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmID;

    @Column(name="title")
    String filmTitle;

    @Column(name="description")
    String filmDescription;

    @Column(name="release_year")
    String filmReleaseYear;

    @Column(name="language_id")
    char filmLanguageID;

    @Column(name="length")
    int filmLength;

    @Column(name="rating")
    String filmRating;

    //Constructors//
    public Film(String filmTitle, String filmDescription, String filmReleaseYear, char filmLanguageID, int filmLength, String filmRating) {
        this.filmTitle = filmTitle;
        this.filmDescription = filmDescription;
        this.filmReleaseYear = filmReleaseYear;
        this.filmLanguageID = filmLanguageID;
        this.filmLength = filmLength;
        this.filmRating = filmRating;
    }

    public Film(){}

    //Methods//
    public int getFilmID() {
        return filmID;
    }

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    public String getFilmReleaseYear() {
        return filmReleaseYear;
    }

    public void setFilmReleaseYear(String filmReleaseYear) {
        this.filmReleaseYear = filmReleaseYear;
    }

    public char getFilmLanguageID() {
        return filmLanguageID;
    }

    public void setFilmLanguageID(char filmLanguageID) {
        this.filmLanguageID = filmLanguageID;
    }

    public int getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(int filmLength) {
        this.filmLength = filmLength;
    }

    public String getFilmRating() {
        return filmRating;
    }

    public void setFilmRating(String filmRating) {
        this.filmRating = filmRating;
    }
}
