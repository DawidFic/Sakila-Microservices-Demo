package com.Sakila_Microservices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorInterface extends JpaRepository<Actor, Integer> {
}
