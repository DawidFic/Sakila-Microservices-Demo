package com.Sakila_Microservices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryInterface extends JpaRepository<Country, Integer> {
}
