package com.as.techheaven.productserviceapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "categories")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="category_name", length =20, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "product_id", unique = true)
    private Product product;

}
