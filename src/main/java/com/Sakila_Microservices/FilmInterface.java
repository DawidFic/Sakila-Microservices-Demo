package com.Sakila_Microservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FilmInterface extends JpaRepository<Film, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM sakila.film WHERE film.title = ?1")
    Optional<Film> findByTitle(String title);

    @Query(nativeQuery = true, value = "select actor.first_name, film.title " +
            "from ((film_actor inner join actor on film_actor.actor_id = actor.actor_id) " +
            "inner join film on film_actor.film_id = film.film_id) " +
            "where actor.first_name = ?1")
    List<Film> findFilmsByActor(String actorFirstName);

}
