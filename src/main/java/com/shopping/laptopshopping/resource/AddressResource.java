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
import com.shopping.laptopshopping.service.AddressService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class AddressResource {

  @Autowired AddressService addressService;

  @GetMapping("address")
  public List<Address> getAllAddresses() {
    return addressService.getAllAddresses();
  }

  @GetMapping("address/{id}")
  public Address getAddressById(@PathVariable("id") Integer id) {
    return addressService.getAddressById(id);
  }

  @PostMapping("address")
  public Address saveAddress(@RequestBody Address address) {
    return addressService.saveOrUpdateAddress(address);
  }

  @PutMapping("address")
  public Address updateAddress(@RequestBody Address address) {
    return addressService.saveOrUpdateAddress(address);
  }

  @DeleteMapping("address/{id}")
  public void deleteAddress(@PathVariable("id") Integer id) {
    addressService.deleteAddressById(id);
  }
}
