package com.as.techheaven.productserviceapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "products")
@JsonIgnoreProperties({"brand", "category", "discount", "productImages", "specifications"})
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

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToOne(mappedBy = "product")
    @JsonIgnore
    private Discount discount;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductImage> productImages;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductSpecification> specifications;

}
