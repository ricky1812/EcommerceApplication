package org.example.ecommerceapplication.controllers;

import java.util.ArrayList;
import java.util.List;
import org.example.ecommerceapplication.models.Product;
import org.example.ecommerceapplication.services.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public Product getSingleProduct(@PathVariable("id") long id) {
    return productService.getSingleProduct(id);

  }

  @GetMapping
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @PostMapping
  public Product createProduct(Product p) {
    return new Product();

  }

  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable("id") long id) {

  }

  @PatchMapping("/{id}")
  public Product updateProduct(@PathVariable("id") long id, @RequestBody Product p) {
    return p;
  }


}
