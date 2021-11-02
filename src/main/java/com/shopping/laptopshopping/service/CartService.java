package com.shopping.laptopshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.laptopshopping.entity.Cart;
import com.shopping.laptopshopping.repository.CartRepository;

@Service
public class CartService {

  @Autowired CartRepository cartRepo;

  public List<Cart> getAllCarts() {
    List<Cart> carts = new ArrayList<>();
    try {
      carts = cartRepo.findAll();
    } catch (Exception exception) {
      System.out.println("Exception while finding all Carts: " + exception);
    }
    return carts;
  }

  public Cart getCartById(Integer id) {
    Cart cart = null;
    try {
      Optional<Cart> cartOptional = cartRepo.findById(id);
      if (cartOptional.isPresent()) {
        cart = cartOptional.get();
      } else {
        System.out.println("Cart not found with id: " + id);
      }
    } catch (IllegalArgumentException exception) {
      System.out.println("Exception while finding Cart: " + exception);
    }
    return cart;
  }

  public Cart saveOrUpdateCart(Cart cart) {
    Cart savedCart = null;
    try {
      savedCart = cartRepo.save(cart);
    } catch (Exception exception) {
      System.out.println("Exception while saving/updating Cart: " + exception);
    }
    return savedCart;
  }

  public boolean deleteCartById(Integer id) {
    try {
      cartRepo.deleteById(id);
      return true;
    } catch (Exception exception) {
      System.out.println("Exception while deleting Cart: " + exception);
      return false;
    }
  }
}
