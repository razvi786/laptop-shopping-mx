package com.shopping.laptopshopping.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.laptopshopping.entity.User;
import com.shopping.laptopshopping.repository.UserRepository;

@Service
public class UserService {

  @Autowired UserRepository userRepo;

  public List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    try {
      users = userRepo.findAll();
    } catch (Exception exception) {
      System.out.println("Exception while finding all users: " + exception);
    }
    return users;
  }

  public User getUserById(Integer id) {
    User user = null;
    try {
      Optional<User> userOptional = userRepo.findById(id);
      if (userOptional.isPresent()) {
        user = userOptional.get();
      } else {
        System.out.println("User not found with id: " + id);
      }
    } catch (IllegalArgumentException exception) {
      System.out.println("Exception while finding User: " + exception);
    }
    return user;
  }

  public User saveOrUpdateUser(User user) {
    User savedUser = null;
    try {
      savedUser = userRepo.save(user);
    } catch (Exception exception) {
      System.out.println("Exception while saving/updating User: " + exception);
    }
    return savedUser;
  }

  public boolean deleteUserById(Integer id) {
    try {
      userRepo.deleteById(id);
      return true;
    } catch (Exception exception) {
      System.out.println("Exception while deleting User: " + exception);
      return false;
    }
  }
}
