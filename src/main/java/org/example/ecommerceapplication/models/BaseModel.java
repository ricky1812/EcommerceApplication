package org.example.ecommerceapplication.models;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @PrePersist
  protected void onCreate() {
    LocalDateTime localDateTime = LocalDateTime.now();
    createdAt = localDateTime;
    updatedAt = localDateTime;
  }

  @PreUpdate
  protected void onUpdate() {
    LocalDateTime localDateTime = LocalDateTime.now();
    updatedAt = localDateTime;
  }


}
