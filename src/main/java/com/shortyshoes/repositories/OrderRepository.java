package com.shortyshoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shortyshoes.models.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
