package com.as.techheaven.productserviceapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestSpecificationDto {

    private String specificationName;
    private String specificationValue;

}
