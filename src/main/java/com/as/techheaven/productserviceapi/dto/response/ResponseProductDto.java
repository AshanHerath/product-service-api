package com.as.techheaven.productserviceapi.dto.response;

import com.as.techheaven.productserviceapi.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseProductDto {

    private Long id;
    private String name;
    private String description;
    private int quantity;
    private double price;
    private boolean stockStatus;
    private boolean status;
    private Brand brand;
    private Category category;
    private Discount discount;
    private List<ProductImage> productImages;
    private List<ProductSpecification> specifications;

}
