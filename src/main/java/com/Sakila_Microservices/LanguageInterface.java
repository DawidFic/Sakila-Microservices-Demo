package com.Sakila_Microservices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageInterface extends JpaRepository<Language, Integer> {
}
