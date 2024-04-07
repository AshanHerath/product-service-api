package com.as.techheaven.productserviceapi.service;

import com.as.techheaven.productserviceapi.dto.paginate.PaginateBrandResponseDto;
import com.as.techheaven.productserviceapi.dto.request.RequestBrandDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseBrandDto;

public interface ProductBrandService {

    public void createBrand(RequestBrandDto dto);
    public void updateBrand(long brandId, RequestBrandDto dto);
    public ResponseBrandDto findBrand(long brandId);
    public void deleteBrand(long brandId);
    public PaginateBrandResponseDto findAllBrands(int page, int size, String searchText);

}
