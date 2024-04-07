package com.as.techheaven.productserviceapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestCategoryDto {

    private String name;
    private List<RequestSpecificationTitleDto> specifications;

}
