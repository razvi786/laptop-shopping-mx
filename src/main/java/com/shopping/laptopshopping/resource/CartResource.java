package com.shopping.laptopshopping.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.laptopshopping.entity.Cart;
import com.shopping.laptopshopping.service.CartService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class CartResource {

  @Autowired CartService cartService;

  @GetMapping("cart")
  public List<Cart> getCarts() {
    return cartService.getAllCarts();
  }

  @GetMapping("cart/{id}")
  public Cart getCartById(@PathVariable("id") Integer id) {
    return cartService.getCartById(id);
  }

  @PostMapping("cart")
  public Cart saveCart(@RequestBody Cart cart) {
    return cartService.saveOrUpdateCart(cart);
  }

  @PutMapping("cart")
  public Cart updateCart(@RequestBody Cart cart) {
    return cartService.saveOrUpdateCart(cart);
  }

  @DeleteMapping("cart/{id}")
  public boolean deleteCart(@PathVariable("id") Integer id) {
    return cartService.deleteCartById(id);
  }
}
