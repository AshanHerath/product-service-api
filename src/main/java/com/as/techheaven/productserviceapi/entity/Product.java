package com.as.techheaven.productserviceapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "products")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String name;

    @Lob
    @Column(name = "product_description", nullable = false)
    private String description;

    @Column(name = "product_quantity", nullable = false)
    private int quantity;

    @Column(name = "unit_proce", nullable = false)
    private double price;

    @Column(name = "stock_status")
    private boolean stockStatus;

    @Column(name = "status")
    private boolean status;

    @OneToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL)
    private Discount discount;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductSpecification> specifications;

}
