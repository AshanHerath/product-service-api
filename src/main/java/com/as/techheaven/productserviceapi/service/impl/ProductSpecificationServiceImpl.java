package com.as.techheaven.productserviceapi.service.impl;

import com.as.techheaven.productserviceapi.dto.request.RequestSpecificationDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseSpecificationDto;
import com.as.techheaven.productserviceapi.entity.ProductSpecification;
import com.as.techheaven.productserviceapi.repo.ProductSpecificationRepository;
import com.as.techheaven.productserviceapi.service.ProductSpecificationService;
import com.as.techheaven.productserviceapi.util.mapper.ProductSpecificationMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductSpecificationServiceImpl implements ProductSpecificationService {

    private final ProductSpecificationRepository specificationRepository;
    private final ProductSpecificationMapper productSpecificationMapper;

    @Override
    public void updateSpecification(long specId, RequestSpecificationDto dto) {

        Optional<ProductSpecification> selectedSpec = specificationRepository.findById(specId);
        if (selectedSpec.isEmpty()) throw new EntityNotFoundException("Specification not found");
        ProductSpecification productSpecification = selectedSpec.get();
        productSpecification.setSpecificationName(dto.getSpecificationName());
        productSpecification.setSpecificationValue(dto.getSpecificationValue());
        specificationRepository.save(productSpecification);

    }

    @Override
    public ResponseSpecificationDto findSpecification(long specId) {

        Optional<ProductSpecification> selectedSpec = specificationRepository.findById(specId);
        if (selectedSpec.isEmpty()) throw new EntityNotFoundException("Specification not found");
        return productSpecificationMapper.toResponseSpecificationDto(selectedSpec.get());
    }

    @Override
    public void deleteSpecification(long specId) {

        Optional<ProductSpecification> selectedSpec = specificationRepository.findById(specId);
        if (selectedSpec.isEmpty()) throw new EntityNotFoundException("Specification not found");
        specificationRepository.deleteById(selectedSpec.get().getId());

    }
}
