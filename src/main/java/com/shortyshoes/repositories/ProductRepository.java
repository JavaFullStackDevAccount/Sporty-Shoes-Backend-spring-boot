package com.shortyshoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shortyshoes.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
