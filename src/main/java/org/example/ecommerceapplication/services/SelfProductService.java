package org.example.ecommerceapplication.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.example.ecommerceapplication.dtos.FakeStoreProductDto;
import org.example.ecommerceapplication.exceptions.ProductNotFoundException;
import org.example.ecommerceapplication.models.Category;
import org.example.ecommerceapplication.models.Product;
import org.example.ecommerceapplication.repositories.CategoryRepository;
import org.example.ecommerceapplication.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("SelfProductService")
public class SelfProductService implements ProductService {

  private final RestTemplate restTemplate;

  private final ProductRepository productRepository;
  private CategoryRepository categoryRepository;


  public SelfProductService(RestTemplate restTemplate, ProductRepository productRepository,
      CategoryRepository categoryRepository) {
    this.restTemplate = restTemplate;
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Product getSingleProduct(long id) throws ProductNotFoundException {
    Product product = productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException(id, "Product not found"));

    return product;
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product createProduct(Product inputProduct) {
    // Step 1: Handle Category
    if (inputProduct.getCategory() != null && inputProduct.getCategory().getCategoryName() != null) {
      String categoryName = inputProduct.getCategory().getCategoryName().trim();

      Category existingCategory = categoryRepository.findByCategoryName(categoryName)
          .orElseGet(() -> {
            Category newCategory = new Category();
            newCategory.setCategoryName(categoryName);
            return categoryRepository.save(newCategory);
          });

      inputProduct.setCategory(existingCategory);
    }

    // Step 2: Handle Product (check if it already exists by title)
    Optional<Product> existingProductOpt = productRepository.findByTitle(inputProduct.getTitle());

    if (existingProductOpt.isPresent()) {
      Product existingProduct = existingProductOpt.get();
      existingProduct.setPrice(inputProduct.getPrice());
      existingProduct.setDescription(inputProduct.getDescription());
      existingProduct.setImage(inputProduct.getImage());
      existingProduct.setCategory(inputProduct.getCategory());  // already resolved

      return productRepository.save(existingProduct);
    } else {
      return productRepository.save(inputProduct);
    }
  }
  @Override
  public void deleteProduct(long id) {

  }

  @Override
  public void updateProduct(long id, Product product) {

  }

  public List<Product> intializeProducts() {
    FakeStoreProductDto[] fakeStoreProductDtos = restTemplate.getForObject(
        "https://fakestoreapi.com/products/", FakeStoreProductDto[].class);
    List<Product> productList = new ArrayList<>();
    for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
      String categoryName = fakeStoreProductDto.getCategory();
      Category category = categoryRepository.findByCategoryName(categoryName).orElseGet(() -> {
        Category newCategory = new Category();
        newCategory.setCategoryName(categoryName);
        return categoryRepository.save(newCategory);
      });
      Product product = productRepository.findByTitle(fakeStoreProductDto.getTitle())
          .orElseGet(() -> {
            Product newProduct = convertFakeStoreDTOtoProduct(fakeStoreProductDto);
            newProduct.setCategory(category);
            return productRepository.save(newProduct);

          });
      productList.add(product);
    }
    return productList;


  }

  private Product convertFakeStoreDTOtoProduct(FakeStoreProductDto fakeStoreProductDto) {
    Product product = new Product();
    product.setTitle(fakeStoreProductDto.getTitle());
    product.setPrice(fakeStoreProductDto.getPrice());
    product.setImage(fakeStoreProductDto.getImage());
//    product.setDescription(fakeStoreProductDto.getDescription());
    return product;
  }
}
