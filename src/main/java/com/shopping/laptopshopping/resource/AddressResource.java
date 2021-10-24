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

import com.shopping.laptopshopping.entity.Address;
import com.shopping.laptopshopping.repository.AddressRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class AddressResource {

  @Autowired AddressRepository addressRepo;

  @GetMapping("address")
  public List<Address> getAllAddresses() {
    return addressRepo.findAll();
  }

  @GetMapping("address/{id}")
  public Address getAddressById(@PathVariable("id") Integer id) {
    return addressRepo.findById(id).orElse(null);
  }

  @PostMapping("address")
  public Address saveAddress(@RequestBody Address address) {
    return addressRepo.save(address);
  }

  @PutMapping("address")
  public Address updateAddress(@RequestBody Address address) {
    return addressRepo.save(address);
  }

  @DeleteMapping("address/{id}")
  public void deleteAddress(@PathVariable("id") Integer id) {
    addressRepo.deleteById(id);
  }
}
