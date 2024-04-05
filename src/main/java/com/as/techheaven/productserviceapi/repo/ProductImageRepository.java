package com.as.techheaven.productserviceapi.repo;

import com.as.techheaven.productserviceapi.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
