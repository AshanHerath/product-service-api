package com.as.techheaven.productserviceapi.service.impl;

import com.as.techheaven.productserviceapi.dto.paginate.PaginateBrandResponseDto;
import com.as.techheaven.productserviceapi.dto.request.RequestBrandDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseBrandDto;
import com.as.techheaven.productserviceapi.entity.Brand;
import com.as.techheaven.productserviceapi.repo.BrandRepository;
import com.as.techheaven.productserviceapi.service.ProductBrandService;
import com.as.techheaven.productserviceapi.util.mapper.ProductBrandMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductBrandServiceImpl implements ProductBrandService {

    private final BrandRepository brandRepository;
    private final ProductBrandMapper brandMapper;

    @Override
    public void createBrand(RequestBrandDto dto) {

        Brand brand = Brand.builder()
                .name(dto.getName())
                .brandImg(dto.getBrandImg())
                .build();
        brandRepository.save(brand);

    }

    @Override
    public void updateBrand(long brandId, RequestBrandDto dto) {

        Optional<Brand> selectedBrand = brandRepository.findById(brandId);
        if (selectedBrand.isEmpty()) throw new EntityNotFoundException("Brand not found");
        Brand brand = selectedBrand.get();
        brand.setName(dto.getName());
        brand.setBrandImg(dto.getBrandImg());
        brandRepository.save(brand);

    }

    @Override
    public ResponseBrandDto findBrand(long brandId) {

        Optional<Brand> selectedBrand = brandRepository.findById(brandId);
        if (selectedBrand.isEmpty()) throw new EntityNotFoundException("Brand not found");
        return brandMapper.toResponseBrandDto(selectedBrand.get());

    }

    @Override
    public void deleteBrand(long brandId) {

        Optional<Brand> selectedBrand = brandRepository.findById(brandId);
        if (selectedBrand.isEmpty()) throw new EntityNotFoundException("Brand not found");
        brandRepository.deleteById(selectedBrand.get().getId());

    }

    @Override
    public PaginateBrandResponseDto findAllBrands(int page, int size, String searchText) {
        return null;
    }
}
