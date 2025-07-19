package org.example.ecommerceapplication.models;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseModel {

  private long id;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

}
