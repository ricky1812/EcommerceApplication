package org.example.ecommerceapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundExceptionDTO {

  private String message;
  private String resolution;

}
