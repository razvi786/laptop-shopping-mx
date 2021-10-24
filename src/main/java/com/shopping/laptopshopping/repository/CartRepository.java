package com.shopping.laptopshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.laptopshopping.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {}
