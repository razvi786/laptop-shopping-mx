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

import com.shopping.laptopshopping.entity.Order;
import com.shopping.laptopshopping.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class OrderResource {

  @Autowired OrderService orderService;

  @GetMapping("order")
  public List<Order> getOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("order/{id}")
  public Order getOrderById(@PathVariable("id") Integer id) {
    return orderService.getOrderById(id);
  }

  @PostMapping("order")
  public Order saveOrder(@RequestBody Order order) {
    return orderService.saveOrUpdateOrder(order);
  }

  @PutMapping("order")
  public Order updateOrder(@RequestBody Order order) {
    return orderService.saveOrUpdateOrder(order);
  }

  @DeleteMapping("order/{id}")
  public boolean deleteOrder(@PathVariable("id") Integer id) {
    return orderService.deleteOrderById(id);
  }
}
