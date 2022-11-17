package com.Sakila;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface FilmInterface extends JpaRepository<Film, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM sakila.film WHERE film.title LIKE %?1%")
    List<Film> findByTitle(String title);

    @Query(nativeQuery = true, value = "SELECT sakila.film.* FROM sakila.film INNER JOIN sakila.film_actor ON sakila.film.film_id = sakila.film_actor.film_id INNER JOIN sakila.actor ON sakila.actor.actor_id = sakila.film_actor.actor_id WHERE sakila.actor.first_name = ?1")
    Set<Film> findFilmsByActor(String actorFirstName);
}