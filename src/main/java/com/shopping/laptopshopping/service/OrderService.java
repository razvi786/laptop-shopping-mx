package com.shopping.laptopshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.laptopshopping.entity.Order;
import com.shopping.laptopshopping.repository.OrderRepository;

@Service
public class OrderService {

  @Autowired OrderRepository orderRepo;

  public List<Order> getAllOrders() {
    List<Order> orders = new ArrayList<>();
    try {
      orders = orderRepo.findAll();
    } catch (Exception exception) {
      System.out.println("Exception while finding all Orders: " + exception);
    }
    return orders;
  }

  public Order getOrderById(Integer id) {
    Order order = null;
    try {
      Optional<Order> orderOptional = orderRepo.findById(id);
      if (orderOptional.isPresent()) {
        order = orderOptional.get();
      } else {
        System.out.println("Order not found with id: " + id);
      }
    } catch (IllegalArgumentException exception) {
      System.out.println("Exception while finding Order: " + exception);
    }
    return order;
  }

  public Order saveOrUpdateOrder(Order order) {
    Order savedOrder = null;
    try {
      savedOrder = orderRepo.save(order);
    } catch (Exception exception) {
      System.out.println("Exception while saving/updating Order: " + exception);
    }
    return savedOrder;
  }

  public boolean deleteOrderById(Integer id) {
    try {
      orderRepo.deleteById(id);
      return true;
    } catch (Exception exception) {
      System.out.println("Exception while deleting Order: " + exception);
      return false;
    }
  }
}
