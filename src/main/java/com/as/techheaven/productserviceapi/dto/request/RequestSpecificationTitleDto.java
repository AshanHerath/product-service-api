package com.as.techheaven.productserviceapi.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Setter
@Getter

public class RequestSpecificationTitleDto {

    private long categoryId;
    private String spec;


}
