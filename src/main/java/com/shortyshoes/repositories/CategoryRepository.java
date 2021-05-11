package com.shortyshoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shortyshoes.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
