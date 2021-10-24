package com.shopping.laptopshopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.laptopshopping.entity.User;
import com.shopping.laptopshopping.exception.DatabaseException;
import com.shopping.laptopshopping.repository.UserRepository;

@Service
public class UserService {

  @Autowired UserRepository userRepo;

  public List<User> getAllUsers() throws DatabaseException {
    try {
      return userRepo.findAll();
    } catch (Exception exception) {
      throw new DatabaseException(
          "Exception while finding all users: " + exception.getLocalizedMessage());
    }
  }

  public User getUserById(Integer id) throws DatabaseException {
    try {
      Optional<User> userOptional = userRepo.findById(id);
      if (userOptional.isPresent()) {
        return userOptional.get();
      } else {
        throw new DatabaseException("User not found with id: " + id);
      }
    } catch (IllegalArgumentException exception) {
      throw new DatabaseException(
          "Exception while finding User: " + exception.getLocalizedMessage());
    }
  }

  public User saveOrUpdateUser(User user) throws DatabaseException {
    try {
      return userRepo.save(user);
    } catch (Exception exception) {
      throw new DatabaseException(
          "Exception while saving/updating User: " + exception.getLocalizedMessage());
    }
  }

  public void deleteUserById(Integer id) throws DatabaseException {
    try {
      userRepo.deleteById(id);
    } catch (Exception exception) {
      throw new DatabaseException(
          "Exception while deleting User: " + exception.getLocalizedMessage());
    }
  }
}
