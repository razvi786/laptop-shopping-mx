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

import com.shopping.laptopshopping.entity.Delivery;
import com.shopping.laptopshopping.service.DeliveryService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class DeliveryResource {

  @Autowired DeliveryService deliveryService;

  @GetMapping("delivery")
  public List<Delivery> getDeliveries() {
    return deliveryService.getAllDeliveries();
  }

  @GetMapping("delivery/{id}")
  public Delivery getDeliveryById(@PathVariable("id") Integer id) {
    return deliveryService.getDeliveryById(id);
  }

  @PostMapping("delivery")
  public Delivery saveDelivery(@RequestBody Delivery delivery) {
    return deliveryService.saveOrUpdateDelivery(delivery);
  }

  @PutMapping("delivery")
  public Delivery updateDelivery(@RequestBody Delivery delivery) {
    return deliveryService.saveOrUpdateDelivery(delivery);
  }

  @DeleteMapping("delivery/{id}")
  public void deleteDelivery(@PathVariable("id") Integer id) {
    deliveryService.deleteDeliveryById(id);
  }
}
