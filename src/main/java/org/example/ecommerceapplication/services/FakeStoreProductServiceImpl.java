package org.example.ecommerceapplication.services;

import java.util.ArrayList;
import java.util.List;
import org.example.ecommerceapplication.dtos.FakeStoreProductDto;
import org.example.ecommerceapplication.exceptions.ProductNotFoundException;
import org.example.ecommerceapplication.models.Category;
import org.example.ecommerceapplication.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductServiceImpl implements ProductService {

  private final RestTemplate restTemplate;

  public FakeStoreProductServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public Product getSingleProduct(long id) throws ProductNotFoundException {
    //throw new ProductNotFoundException(id, "Product is not present in db");

    FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
        "https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);
    return convertFakeStoreDtoToProduct(fakeStoreProductDto);
  }

  @Override
  public List<Product> getAllProducts() {
    FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
        "https://fakestoreapi.com/products/", FakeStoreProductDto[].class
    );
    List<Product> productList = new ArrayList<>();
    for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
      productList.add(convertFakeStoreDtoToProduct(fakeStoreProductDto));
    }
    return productList;

  }

  @Override
  public Product createProduct(Product product) {
    return null;
  }

  @Override
  public void deleteProduct(long id) {

  }

  @Override
  public void updateProduct(long id, Product product) {

  }

  @Override
  public List<Product> intializeProducts() {
    return null;

  }

  private Product convertFakeStoreDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
    Product product = new Product();
    product.setTitle(fakeStoreProductDto.getTitle());
    product.setPrice(fakeStoreProductDto.getPrice());
    product.setImage(fakeStoreProductDto.getImage());
    product.setDescription(fakeStoreProductDto.getDescription());
    product.setId(fakeStoreProductDto.getId());
    Category category = new Category();
    category.setCategoryName(fakeStoreProductDto.getCategory());
    category.setDescription(fakeStoreProductDto.getCategory());

    product.setCategory(category);
    return product;
  }
}
