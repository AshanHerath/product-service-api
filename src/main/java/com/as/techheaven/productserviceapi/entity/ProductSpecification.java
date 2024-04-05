package com.as.techheaven.productserviceapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "product_specifications")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSpecification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "spec_name", nullable = false)
    private String specificationName;

    @Column(name = "spec_value", nullable = false)
    private String specificationValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
