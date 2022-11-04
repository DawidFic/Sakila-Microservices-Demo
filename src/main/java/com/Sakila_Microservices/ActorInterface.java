package com.Sakila_Microservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorInterface extends JpaRepository<Actor, Integer> {

    @Query(value = "SELECT DISTINCT * FROM actor WHERE first_name = ?1 AND last_name = ?2", nativeQuery = true)
    List<Actor> findByNames(String fname, String lname);
}
