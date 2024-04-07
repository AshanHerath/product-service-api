package com.as.techheaven.productserviceapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseProductImageDto {

    private long id;
    private String imgUrl;
    private Long productId;

}
