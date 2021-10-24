package com.shopping.laptopshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.laptopshopping.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {}
