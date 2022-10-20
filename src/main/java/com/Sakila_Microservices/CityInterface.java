package com.Sakila_Microservices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CityInterface extends JpaRepository<City, Integer> {
}
