package com.as.techheaven.productserviceapi.repo;

import com.as.techheaven.productserviceapi.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepository extends JpaRepository<Discount, Long> {
}
