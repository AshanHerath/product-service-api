package com.as.techheaven.productserviceapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseSpecificationTitlrDto {

    private String id;
    private long categoryId;
    private String spec;

}
