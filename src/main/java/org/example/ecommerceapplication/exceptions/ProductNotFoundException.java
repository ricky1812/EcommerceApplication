package org.example.ecommerceapplication.exceptions;

import lombok.Getter;

@Getter
public class ProductNotFoundException extends Exception {

  private long productId;

  public ProductNotFoundException(String messgae) {
    super(messgae);
  }

  public ProductNotFoundException(long productId, String message) {
    super(message);
    this.productId = productId;

  }

}
