package com.shopping.laptopshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.laptopshopping.entity.Delivery;
import com.shopping.laptopshopping.repository.DeliveryRepository;

@Service
public class DeliveryService {

  @Autowired DeliveryRepository deliveryRepo;

  public List<Delivery> getAllDeliveries() {
    List<Delivery> deliveries = new ArrayList<>();
    try {
      deliveries = deliveryRepo.findAll();
    } catch (Exception exception) {
      System.out.println("Exception while finding all Deliveries: " + exception);
    }
    return deliveries;
  }

  public Delivery getDeliveryById(Integer id) {
    Delivery delivery = null;
    try {
      Optional<Delivery> deliveryOptional = deliveryRepo.findById(id);
      if (deliveryOptional.isPresent()) {
        delivery = deliveryOptional.get();
      } else {
        System.out.println("Delivery not found with id: " + id);
      }
    } catch (IllegalArgumentException exception) {
      System.out.println("Exception while finding Delivery: " + exception);
    }
    return delivery;
  }

  public Delivery saveOrUpdateDelivery(Delivery delivery) {
    Delivery savedDelivery = null;
    try {
      savedDelivery = deliveryRepo.save(delivery);
    } catch (Exception exception) {
      System.out.println("Exception while saving/updating Delivery: " + exception);
    }
    return savedDelivery;
  }

  public boolean deleteDeliveryById(Integer id) {
    try {
      deliveryRepo.deleteById(id);
      return true;
    } catch (Exception exception) {
      System.out.println("Exception while deleting Delivery: " + exception);
      return false;
    }
  }
}
