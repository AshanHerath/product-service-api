package com.as.techheaven.productserviceapi.dto.response;

import com.as.techheaven.productserviceapi.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDiscountDto {

    private long id;
    private String title;
    private String discountType;
    private String discount;
    private Product product;

}
