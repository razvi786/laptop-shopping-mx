package com.shopping.laptopshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.laptopshopping.entity.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, Integer> {}
