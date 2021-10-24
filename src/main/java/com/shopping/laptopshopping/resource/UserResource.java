package com.shopping.laptopshopping.resource;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.shopping.laptopshopping.exception.DatabaseException;
import com.shopping.laptopshopping.response.Response;
import com.shopping.laptopshopping.response.ResponseGenerator;
import com.shopping.laptopshopping.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class UserResource {

  @Autowired UserService userService;

  @Autowired ResponseGenerator responseGenerator;

  @GetMapping("user")
  public ResponseEntity<Response<List<User>>> getUsers() {
    UUID transactionId = UUID.randomUUID();
    List<User> users;
    try {
      users = userService.getAllUsers();
      return new ResponseEntity<Response<List<User>>>(
          responseGenerator.generateUserListSuccessResponse(transactionId, users), HttpStatus.OK);
    } catch (DatabaseException exception) {
      return new ResponseEntity<Response<List<User>>>(
          responseGenerator.generateUserListErrorResponse(
              transactionId, HttpStatus.INTERNAL_SERVER_ERROR, exception.getLocalizedMessage()),
          HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("user/{id}")
  public ResponseEntity<Response<User>> getUserById(@PathVariable("id") Integer id) {
    UUID transactionId = UUID.randomUUID();
    try {
      User user = userService.getUserById(id);
      return new ResponseEntity<Response<User>>(
          responseGenerator.generateUserSuccessResponse(transactionId, user), HttpStatus.OK);

    } catch (DatabaseException exception) {
      return new ResponseEntity<Response<User>>(
          responseGenerator.generateUserErrorResponse(
              transactionId, HttpStatus.NOT_FOUND, exception.getLocalizedMessage()),
          HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("user")
  public ResponseEntity<Response<User>> saveUser(@RequestBody User user) {
    UUID transactionId = UUID.randomUUID();
    try {
      User savedUser = userService.saveOrUpdateUser(user);
      return new ResponseEntity<Response<User>>(
          responseGenerator.generateUserSuccessResponse(transactionId, savedUser), HttpStatus.OK);

    } catch (DatabaseException exception) {
      return new ResponseEntity<Response<User>>(
          responseGenerator.generateUserErrorResponse(
              transactionId, HttpStatus.BAD_REQUEST, exception.getLocalizedMessage()),
          HttpStatus.BAD_REQUEST);
    }
  }

  @PutMapping("user")
  public ResponseEntity<Response<User>> updateUser(@RequestBody User user) {
    UUID transactionId = UUID.randomUUID();
    try {
      User updatedUser = userService.saveOrUpdateUser(user);
      return new ResponseEntity<Response<User>>(
          responseGenerator.generateUserSuccessResponse(transactionId, updatedUser), HttpStatus.OK);

    } catch (DatabaseException exception) {
      return new ResponseEntity<Response<User>>(
          responseGenerator.generateUserErrorResponse(
              transactionId, HttpStatus.BAD_REQUEST, exception.getLocalizedMessage()),
          HttpStatus.BAD_REQUEST);
    }
  }

  @DeleteMapping("user/{id}")
  public ResponseEntity<Response<User>> deleteUser(@PathVariable("id") Integer id) {
    UUID transactionId = UUID.randomUUID();
    try {
      userService.deleteUserById(id);
      return new ResponseEntity<Response<User>>(
          responseGenerator.generateUserSuccessResponse(transactionId, null), HttpStatus.OK);

    } catch (DatabaseException exception) {
      return new ResponseEntity<Response<User>>(
          responseGenerator.generateUserErrorResponse(
              transactionId, HttpStatus.BAD_REQUEST, exception.getLocalizedMessage()),
          HttpStatus.BAD_REQUEST);
    }
  }
}
