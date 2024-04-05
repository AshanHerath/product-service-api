package com.as.techheaven.productserviceapi.repo;

import com.as.techheaven.productserviceapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
