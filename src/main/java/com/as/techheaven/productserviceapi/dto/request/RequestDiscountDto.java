package com.as.techheaven.productserviceapi.dto.request;

import com.as.techheaven.productserviceapi.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestDiscountDto {

    private String title;
    private String discountType;
    private String discount;
    private Product product;

}
