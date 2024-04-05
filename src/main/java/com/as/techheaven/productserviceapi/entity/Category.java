package com.as.techheaven.productserviceapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "categorie")
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

    @OneToOne(mappedBy = "category", cascade = CascadeType.ALL)
    private Product product;

}
