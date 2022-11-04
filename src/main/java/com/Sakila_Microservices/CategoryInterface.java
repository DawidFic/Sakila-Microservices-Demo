package com.Sakila_Microservices;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryInterface extends JpaRepository<Category, Integer> {
}
