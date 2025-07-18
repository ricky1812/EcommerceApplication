package org.example.ecommerceapplication.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends BaseModel {

  private String categoryName;
  private String description;

}
