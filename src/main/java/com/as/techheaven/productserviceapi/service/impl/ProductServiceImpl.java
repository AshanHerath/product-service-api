package com.as.techheaven.productserviceapi.service.impl;

import com.as.techheaven.productserviceapi.dto.paginate.PaginateProductResponseDto;
import com.as.techheaven.productserviceapi.dto.request.RequestProductDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseProductDto;
import com.as.techheaven.productserviceapi.entity.Product;
import com.as.techheaven.productserviceapi.repo.ProductRepository;
import com.as.techheaven.productserviceapi.service.ProductService;
import com.as.techheaven.productserviceapi.util.mapper.ProductMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public void createProduct(RequestProductDto dto) {

        Product product = Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .stockStatus(dto.isStockStatus())
                .status(dto.isStatus())
                .brand(dto.getBrand())
                .category(dto.getCategory())
                .discount(dto.getDiscount())
                .productImages(dto.getProductImages())
                .specifications(dto.getSpecifications())
                .build();

        productRepository.save(product);

    }

    @Override
    public void updateProduct(long productId, RequestProductDto dto) {

        Optional<Product> selectedProduct = productRepository.findById(productId);
        if (selectedProduct.isEmpty()) throw new EntityNotFoundException("Product not found");
        Product product = selectedProduct.get();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setQuantity(dto.getQuantity());
        product.setPrice(dto.getPrice());
        product.setStatus(dto.isStatus());
        product.setBrand(dto.getBrand());
        product.setCategory(dto.getCategory());
        product.setDiscount(dto.getDiscount());
        product.setProductImages(dto.getProductImages());
        product.setSpecifications(dto.getSpecifications());

        productRepository.save(product);

    }

    @Override
    public ResponseProductDto findProduct(long productId) {

        Optional<Product> selectedProduct = productRepository.findById(productId);
        if (selectedProduct.isEmpty()) throw new EntityNotFoundException("Product not found");

        return productMapper.toResponseProductDto(selectedProduct.get());
    }

    @Override
    public void deleteProduct(long productId) {

        Optional<Product> selectedProduct = productRepository.findById(productId);
        if (selectedProduct.isEmpty()) throw new EntityNotFoundException("Product not found");

        productRepository.deleteProductById(selectedProduct.get().getId());

    }

    @Override
    public PaginateProductResponseDto findAllProducts(int page, int size, String searchText) {
        searchText = "%" + searchText + "%";
        List<Product> products = productRepository.searchProduct(searchText, PageRequest.of(page, size));
        long productCount = productRepository.countProduct(searchText);
        List<ResponseProductDto> dtos = productMapper.toResponseDoctorDtoList(products);
        return new PaginateProductResponseDto(
                productCount,
                dtos
        );
    }
}
