package com.shopping.laptopshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.laptopshopping.entity.Address;
import com.shopping.laptopshopping.repository.AddressRepository;

@Service
public class AddressService {

  @Autowired AddressRepository addressRepo;

  public List<Address> getAllAddresses() {
    List<Address> addresses = new ArrayList<>();
    try {
      addresses = addressRepo.findAll();
    } catch (Exception exception) {
      System.out.println("Exception while finding all addresses: " + exception);
    }
    return addresses;
  }

  public Address getAddressById(Integer id) {
    Address address = null;
    try {
      Optional<Address> addressOptional = addressRepo.findById(id);
      if (addressOptional.isPresent()) {
        address = addressOptional.get();
      } else {
        System.out.println("Address not found with id: " + id);
      }
    } catch (IllegalArgumentException exception) {
      System.out.println("Exception while finding Address: " + exception);
    }
    return address;
  }

  public Address saveOrUpdateAddress(Address address) {
    Address savedAddress = null;
    try {
      savedAddress = addressRepo.save(address);
    } catch (Exception exception) {
      System.out.println("Exception while saving/updating Address: " + exception);
    }
    return savedAddress;
  }

  public boolean deleteAddressById(Integer id) {
    try {
      addressRepo.deleteById(id);
      return true;
    } catch (Exception exception) {
      System.out.println("Exception while deleting Address: " + exception);
      return false;
    }
  }
}
