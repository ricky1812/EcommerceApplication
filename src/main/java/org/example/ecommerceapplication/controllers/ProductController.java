package org.example.ecommerceapplication.controllers;

import java.util.List;
import org.example.ecommerceapplication.exceptions.ProductNotFoundException;
import org.example.ecommerceapplication.models.Product;
import org.example.ecommerceapplication.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Product> getSingleProduct(@PathVariable("id") long id)
      throws ProductNotFoundException {
    return
        new ResponseEntity<>(productService.getSingleProduct(id),
            HttpStatus.OK);

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
