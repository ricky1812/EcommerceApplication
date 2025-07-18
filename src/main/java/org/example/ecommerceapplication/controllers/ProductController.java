package org.example.ecommerceapplication.controllers;

import java.util.ArrayList;
import java.util.List;
import org.example.ecommerceapplication.models.Product;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  @GetMapping("/{id}")
  public Product getSingleProduct(@PathVariable("id") long id) {
    Product p = new Product();
    return p;

  }
  @GetMapping
  public List<Product> getAllProducts(){
    return new ArrayList<>();
  }
  @PostMapping
  public Product createProduct(Product p){
    return new Product();

  }
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable("id") long id){

  }
  @PatchMapping("/{id}")
  public Product updateProduct(@PathVariable("id") long id, @RequestBody Product p){
    return p;
  }


}
