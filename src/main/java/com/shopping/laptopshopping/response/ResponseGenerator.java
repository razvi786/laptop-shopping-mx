package com.shopping.laptopshopping.response;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.shopping.laptopshopping.entity.User;

@Component
public class ResponseGenerator {

  public Response<List<User>> generateUserListSuccessResponse(UUID transactionId, List<User> users) {

    Header header = new Header();
    header.setTransactionId(transactionId);

    return new Response<>(header, users, null);
  }

  public Response<User> generateUserSuccessResponse(UUID transactionId, User user) {

    Header header = new Header();
    header.setTransactionId(transactionId);

    return new Response<>(header, user, null);
  }

  public Response<List<User>> generateUserListErrorResponse(
      UUID transactionId, HttpStatus status, String message) {

    Header header = new Header();
    header.setTransactionId(transactionId);

    ErrorInfo error = new ErrorInfo();
    error.setStatus(status.toString());
    error.setMessage(message);

    return new Response<>(header, null, error);
  }

  public Response<User> generateUserErrorResponse(
      UUID transactionId, HttpStatus status, String message) {

    Header header = new Header();
    header.setTransactionId(transactionId);

    ErrorInfo error = new ErrorInfo();
    error.setStatus(status.toString());
    error.setMessage(message);

    return new Response<>(header, null, error);
  }
}
