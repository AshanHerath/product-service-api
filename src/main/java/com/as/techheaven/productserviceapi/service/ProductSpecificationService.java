package com.as.techheaven.productserviceapi.service;

import com.as.techheaven.productserviceapi.dto.paginate.PaginateBrandResponseDto;
import com.as.techheaven.productserviceapi.dto.request.RequestBrandDto;
import com.as.techheaven.productserviceapi.dto.request.RequestSpecificationDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseBrandDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseSpecificationDto;

public interface ProductSpecificationService {

    public void updateSpecification(long specId, RequestSpecificationDto dto);
    public ResponseSpecificationDto findSpecification(long specId);
    public void deleteSpecification(long specId);

}
