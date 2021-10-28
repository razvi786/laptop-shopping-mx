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

import com.shopping.laptopshopping.entity.User;
import com.shopping.laptopshopping.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class UserResource {

  @Autowired UserService userService;

  @GetMapping("user")
  public List<User> getUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("user/{id}")
  public User getUserById(@PathVariable("id") Integer id) {
    return userService.getUserById(id);
  }

  @PostMapping("user")
  public User saveUser(@RequestBody User user) {
    return userService.saveOrUpdateUser(user);
  }

  @PutMapping("user")
  public User updateUser(@RequestBody User user) {
    return userService.saveOrUpdateUser(user);
  }

  @DeleteMapping("user/{id}")
  public boolean deleteUser(@PathVariable("id") Integer id) {
    return userService.deleteUserById(id);
  }
}
