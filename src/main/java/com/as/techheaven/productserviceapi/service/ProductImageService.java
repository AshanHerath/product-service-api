package com.as.techheaven.productserviceapi.service;

import com.as.techheaven.productserviceapi.dto.request.RequestProductImageDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseProductImageDto;

public interface ProductImageService {

    public void updateProductImage(long imageId, RequestProductImageDto dto);
    public ResponseProductImageDto findProductImage(long imageId);
    public void deleteProductImage(long imageId);

}
