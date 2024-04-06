package com.as.techheaven.productserviceapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "discounts")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "discount_title", length = 50, nullable = false)
    private String title;

    @Column(name = "discount_type", length = 50, nullable = false)
    private String discountType;

    @Column(name = "discount", nullable = false)
    private String discount;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "product_id", unique = true)
    private Product product;

}
