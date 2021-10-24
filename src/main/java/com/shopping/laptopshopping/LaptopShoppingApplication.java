package com.shopping.laptopshopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class LaptopShoppingApplication {

  public static void main(String[] args) {
    SpringApplication.run(LaptopShoppingApplication.class, args);
  }
}
