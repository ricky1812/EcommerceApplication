package org.example.ecommerceapplication.repositories;

import java.util.List;
import java.util.Optional;
import org.example.ecommerceapplication.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
  @Override
  Optional<Product> findById(Long productId);
  Optional<Product> findByTitle(String title);

  List<Product> findAllById(long id);
//  Page<Product> findAllByPage(PageRequest pageRequest);


}
