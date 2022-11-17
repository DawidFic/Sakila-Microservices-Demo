package com.Sakila;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmActorInterface extends JpaRepository<FilmActor, Integer> {
}
