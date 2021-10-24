package com.shopping.laptopshopping.exception;

public class DatabaseException extends Exception {

  private static final long serialVersionUID = 4420842995291226607L;

  public DatabaseException(String message) {
    super("Database Exception: " + message);
  }
}
