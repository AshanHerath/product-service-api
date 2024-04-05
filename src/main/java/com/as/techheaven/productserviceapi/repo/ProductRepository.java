package com.as.techheaven.productserviceapi.repo;

import com.as.techheaven.productserviceapi.entity.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products WHERE product_name LIKE ?1", nativeQuery = true)
    List<Product> searchProduct(String searchText, PageRequest of);

    @Query(value = "SELECT COUNT(*) FROM products WHERE product_name LIKE ?1", nativeQuery = true)
    long countProduct(String searchText);
}
