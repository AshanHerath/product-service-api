package com.as.techheaven.productserviceapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "brands")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "brand_name", length = 50, nullable = false)
    private String name;

    @Lob
    @Column(name = "brand_imgUrl", nullable = false)
    private String brandImg;

    @OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
    private List<Product> products;

}
