package com.as.techheaven.productserviceapi.service.impl;

import com.as.techheaven.productserviceapi.dto.request.RequestProductImageDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseProductImageDto;
import com.as.techheaven.productserviceapi.entity.ProductImage;
import com.as.techheaven.productserviceapi.repo.ProductImageRepository;
import com.as.techheaven.productserviceapi.service.ProductImageService;
import com.as.techheaven.productserviceapi.util.mapper.ProductImageMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final ProductImageMapper productImageMapper;

    @Override
    public void updateProductImage(long imageId, RequestProductImageDto dto) {

        Optional<ProductImage> selectedImage = productImageRepository.findById(imageId);
        if (selectedImage.isEmpty()) throw new EntityNotFoundException("Product image not found");
        ProductImage productImage = selectedImage.get();
        productImage.setImgUrl(dto.getImgUrl());
        productImageRepository.save(productImage);

    }

    @Override
    public ResponseProductImageDto findProductImage(long imageId) {

        Optional<ProductImage> selectedImage = productImageRepository.findById(imageId);
        if (selectedImage.isEmpty()) throw new EntityNotFoundException("Product image not found");
        return productImageMapper.toResponseImageDto(selectedImage.get());

    }

    @Override
    public void deleteProductImage(long imageId) {

        Optional<ProductImage> selectedImage = productImageRepository.findById(imageId);
        if (selectedImage.isEmpty()) throw new EntityNotFoundException("Product image not found");
        productImageRepository.deleteById(selectedImage.get().getId());

    }
}
