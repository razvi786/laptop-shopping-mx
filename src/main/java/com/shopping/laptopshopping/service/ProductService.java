package com.shopping.laptopshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.laptopshopping.entity.Product;
import com.shopping.laptopshopping.repository.ProductRepository;

@Service
public class ProductService {

  @Autowired ProductRepository productRepo;

  public List<Product> getAllProducts() {
    List<Product> products = new ArrayList<>();
    try {
      products = productRepo.findAll();
    } catch (Exception exception) {
      System.out.println("Exception while finding all Products: " + exception);
    }
    return products;
  }

  public Product getProductById(Integer id) {
    Product product = null;
    try {
      Optional<Product> productOptional = productRepo.findById(id);
      if (productOptional.isPresent()) {
        product = productOptional.get();
      } else {
        System.out.println("Product not found with id: " + id);
      }
    } catch (IllegalArgumentException exception) {
      System.out.println("Exception while finding Product: " + exception);
    }
    return product;
  }

  public Product saveOrUpdateProduct(Product product) {
    Product savedProduct = null;
    try {
      savedProduct = productRepo.save(product);
    } catch (Exception exception) {
      System.out.println("Exception while saving/updating Product: " + exception);
    }
    return savedProduct;
  }

  public boolean deleteProductById(Integer id) {
    try {
      productRepo.deleteById(id);
      return true;
    } catch (Exception exception) {
      System.out.println("Exception while deleting Product: " + exception);
      return false;
    }
  }
}
