package org.example.ecommerceapplication.services;

import java.util.List;
import org.example.ecommerceapplication.exceptions.ProductNotFoundException;
import org.example.ecommerceapplication.models.Product;

public interface ProductService {

  Product getSingleProduct(long id) throws ProductNotFoundException;

  List<Product> getAllProducts();

  Product createProduct(Product product);

  void deleteProduct(long id);

  void updateProduct(long id, Product product);


}
