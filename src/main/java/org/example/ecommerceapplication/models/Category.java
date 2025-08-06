package org.example.ecommerceapplication.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="categories")
public class Category extends BaseModel {
  @Column(unique = true)
  private String categoryName;
  private String description;



}
