package org.example.ecommerceapplication.repositories;

import java.util.List;
import java.util.Optional;
import org.example.ecommerceapplication.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
 Optional<Category> findByCategoryName(String categoryName);

}
