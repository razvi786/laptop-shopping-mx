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
import com.shopping.laptopshopping.repository.DeliveryRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class DeliveryResource {

  @Autowired DeliveryRepository deliveryRepo;

  @GetMapping("delivery")
  public List<Delivery> getDeliveries() {
    return deliveryRepo.findAll();
  }

  @GetMapping("delivery/{id}")
  public Delivery getDeliveryById(@PathVariable("id") Integer id) {
    return deliveryRepo.findById(id).orElse(null);
  }

  @PostMapping("delivery")
  public Delivery saveDelivery(@RequestBody Delivery delivery) {
    return deliveryRepo.save(delivery);
  }

  @PutMapping("delivery")
  public Delivery updateDelivery(@RequestBody Delivery delivery) {
    return deliveryRepo.save(delivery);
  }

  @DeleteMapping("delivery/{id}")
  public void deleteDelivery(@PathVariable("id") Integer id) {
    deliveryRepo.deleteById(id);
  }
}
