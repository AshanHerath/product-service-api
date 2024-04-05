package com.as.techheaven.productserviceapi.repo;

import com.as.techheaven.productserviceapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
