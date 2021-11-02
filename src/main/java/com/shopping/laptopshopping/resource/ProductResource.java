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

import com.shopping.laptopshopping.entity.Product;
import com.shopping.laptopshopping.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/")
public class ProductResource {

  @Autowired ProductService ProductService;

  @GetMapping("product")
  public List<Product> getProducts() {
    return ProductService.getAllProducts();
  }

  @GetMapping("product/{id}")
  public Product getProductById(@PathVariable("id") Integer id) {
    return ProductService.getProductById(id);
  }

  @PostMapping("product")
  public Product saveProduct(@RequestBody Product product) {
    return ProductService.saveOrUpdateProduct(product);
  }

  @PutMapping("product")
  public Product updateProduct(@RequestBody Product product) {
    return ProductService.saveOrUpdateProduct(product);
  }

  @DeleteMapping("product/{id}")
  public boolean deleteProduct(@PathVariable("id") Integer id) {
    return ProductService.deleteProductById(id);
  }
}
