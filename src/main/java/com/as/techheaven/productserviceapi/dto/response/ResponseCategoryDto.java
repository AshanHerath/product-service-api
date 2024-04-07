package com.as.techheaven.productserviceapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ResponseCategoryDto {

    private long id;
    private String name;
    private List<ResponseSpecificationTitlrDto> specifications;

}
