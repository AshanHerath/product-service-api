package com.as.techheaven.productserviceapi.dto.response;

import com.as.techheaven.productserviceapi.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseSpecificationDto {

    private long id;
    private String specificationName;
    private String specificationValue;
    private Product product;

}
