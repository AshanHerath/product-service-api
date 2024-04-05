package com.as.techheaven.productserviceapi.service;

import com.as.techheaven.productserviceapi.dto.paginate.PaginateProductResponseDto;
import com.as.techheaven.productserviceapi.dto.request.RequestProductDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseProductDto;

public interface ProductService {

    public void createProduct(RequestProductDto dto);
    public void updateProduct(long productId, RequestProductDto dto);
    public ResponseProductDto findProduct(long productId);
    public void deleteProduct(long productId);
    public PaginateProductResponseDto findAllProducts(int page, int size, String searchText);

}
