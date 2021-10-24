package com.shopping.laptopshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.laptopshopping.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {}
