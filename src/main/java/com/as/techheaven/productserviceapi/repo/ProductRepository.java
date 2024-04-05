package com.as.techheaven.productserviceapi.repo;

import com.as.techheaven.productserviceapi.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM products p WHERE p.product_name LIKE %?1%", nativeQuery = true)
    List<Product> searchProduct(String searchText, PageRequest of);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.status = false WHERE p.id = :id")
    void deleteProductById(long id);

    @Query(value = "SELECT COUNT(*) FROM products p WHERE p.product_name LIKE %?1% AND p.status = true", nativeQuery = true)
    long countProduct(String searchText);
}
