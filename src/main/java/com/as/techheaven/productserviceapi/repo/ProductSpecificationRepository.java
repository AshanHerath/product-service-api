package com.as.techheaven.productserviceapi.repo;

import com.as.techheaven.productserviceapi.entity.ProductSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSpecificationRepository extends JpaRepository<ProductSpecification, Long> {
}
