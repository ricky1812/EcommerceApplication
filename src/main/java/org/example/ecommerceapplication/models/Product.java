package org.example.ecommerceapplication.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

@Getter
@Setter
@Entity(name="products")
public class Product extends BaseModel {
  @Column(unique = true)
  private String title;
  private double price;
  @ManyToOne(cascade=CascadeType.PERSIST)
  private Category category;
  private String description;
  private String image;


}
