package com.Sakila;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmTest {
    Film film = new Film("Test", "Test Film", "2009", '1', 99, "PG");

    @Test
    public void testConstructor(){
        new Film();
    }

    @Test
    public void testGetFilmID() {
        int tempFilmID = film.getFilmID();
        Assertions.assertEquals(0, tempFilmID, "FAILED TO GET FILM ID");
    }

    @Test
    public void testSetFilmID() {
        film.setFilmID(1);
        Assertions.assertEquals(1, film.getFilmID(), "FAILED TO SET FILM ID");
    }

    @Test
    public void testGetFilmTitle() {
        Assertions.assertEquals("Test", film.getFilmTitle(), "FILM TITLE WAS NOT RETURNED CORRECTLY");
    }

    @Test
    public void testSetFilmTitle() {
        film.setFilmTitle("Test Title");
        Assertions.assertEquals("Test Title", film.getFilmTitle(), "FILM TITLE WAS NOT SET CORRECTLY");
    }

    @Test
    public void testGetFilmDescription() {
        Assertions.assertEquals("Test Film", film.getFilmDescription(), "FILM DESCRIPTION WAS NOT RETURNED CORRECTLY");
    }

    @Test
    public void testSetFilmDescription() {
        film.setFilmDescription("Test Description");
        Assertions.assertEquals("Test Description", film.getFilmDescription(), "FILM DESCRIPTION WAS NOT SET CORRECTLY");
    }

    @Test
    public void testGetFilmReleaseYear() {
        Assertions.assertEquals("2009", film.getFilmReleaseYear(), "FILM RELEASE DATE WAS NOT RETURNED CORRECTLY");
    }

    @Test
    public void testSetFilmReleaseYear() {
        film.setFilmReleaseYear("999");
        Assertions.assertEquals("999", film.getFilmReleaseYear(), "FILM RELEASE DATE WAS NOT SET CORRECTLY");
    }

    @Test
    public void testGetFilmLanguageID() {
        Assertions.assertEquals('1', film.getFilmLanguageID(), "FILM LANGUAGE ID WAS NOT RETURNED CORRECTLY");
    }

    @Test
    public void testSetFilmLanguageID() {
        film.setFilmLanguageID('9');
        Assertions.assertEquals('9', film.getFilmLanguageID(), "FILM LANGUAGE ID WAS NOT RETURNED CORRECTLY");
    }

    @Test
    public void testFilmLength(){
        Assertions.assertEquals(99, film.getFilmLength(), "FILM LENGTH WAS NOT RETURNED CORRECTLY");
    }

    @Test
    public void testSetFilmLength() {
        film.setFilmLength(999);
        Assertions.assertEquals(999, film.getFilmLength(), "FILM LENGTH WAS NOT SET CORRECTLY");
    }

    @Test
    public void testGetFilmRating() {
        Assertions.assertEquals("PG", film.getFilmRating(), "FILM RATING WAS NOT RETURNED CORRECTLY");
    }

    @Test
    public void testSetFilmRating() {
        film.setFilmRating("AAA");
        Assertions.assertEquals("AAA", film.getFilmRating(), "FILM RATING WAS NOT SET CORRECTLY");
    }
}
