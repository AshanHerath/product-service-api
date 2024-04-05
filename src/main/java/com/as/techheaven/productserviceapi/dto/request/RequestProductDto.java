package com.as.techheaven.productserviceapi.dto.request;

import com.as.techheaven.productserviceapi.entity.Brand;
import com.as.techheaven.productserviceapi.entity.Category;
import com.as.techheaven.productserviceapi.entity.Discount;
import com.as.techheaven.productserviceapi.entity.ProductImage;
import com.as.techheaven.productserviceapi.entity.ProductSpecification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestProductDto {
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
