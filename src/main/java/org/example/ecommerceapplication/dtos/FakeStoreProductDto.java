package org.example.ecommerceapplication.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {

  private String title;
  private double price;
  private String category;
  private String description;
  private String image;
  private long id;

}
