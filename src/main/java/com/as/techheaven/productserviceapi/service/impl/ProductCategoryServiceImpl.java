package com.as.techheaven.productserviceapi.service.impl;

import com.as.techheaven.productserviceapi.dto.paginate.PaginateCategoryResponseDto;
import com.as.techheaven.productserviceapi.dto.request.RequestCategoryDto;
import com.as.techheaven.productserviceapi.dto.request.RequestSpecificationTitleDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseCategoryDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseSpecificationTitlrDto;
import com.as.techheaven.productserviceapi.entity.Category;
import com.as.techheaven.productserviceapi.repo.CategoryRepository;
import com.as.techheaven.productserviceapi.service.ProductCategoryService;
import com.as.techheaven.productserviceapi.util.mapper.ProductCategoryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductCategoryAspectsServiceImpl productCategoryAspectsService;

    @Override
    public void createCategory(RequestCategoryDto dto) {
        Category category = Category.builder()
                .name(dto.getName())
                .build();
        categoryRepository.save(category);

        Category savedCategory = categoryRepository.save(category);

        if (savedCategory != null) {
            Long categoryId = savedCategory.getId();

            List<RequestSpecificationTitleDto> specifications = dto.getSpecifications().stream()
                    .map(specification -> {
                        specification.setCategoryId(categoryId);
                        return specification;
                    })
                    .collect(Collectors.toList());

            productCategoryAspectsService.saveSpecifications(specifications);
        }


    }

    @Override
    public void updateCategory(long categoryId, RequestCategoryDto dto) {

        Optional<Category> selectedCategory = categoryRepository.findById(categoryId);
        if (selectedCategory.isEmpty()) throw new EntityNotFoundException("Category not found");
        Category category = selectedCategory.get();
        category.setName(dto.getName());
        categoryRepository.save(category);

    }

    @Override
    public ResponseCategoryDto findCategory(long categoryId) {

        Optional<Category> selectedCategory = categoryRepository.findById(categoryId);
        if (selectedCategory.isEmpty()) throw new EntityNotFoundException("Category not found");
        List<ResponseSpecificationTitlrDto> responseSpecifications = productCategoryAspectsService
                .getSpecificationsByCategoryId(selectedCategory.get().getId()).stream()
                .map(specification -> new ResponseSpecificationTitlrDto(specification.getId(), specification.getCategoryId(), specification.getSpec()))
                .collect(Collectors.toList());

        ResponseCategoryDto responseCategoryDto = ResponseCategoryDto.builder()
                .id(selectedCategory.get().getId())
                .name(selectedCategory.get().getName())
                .specifications(responseSpecifications)
                .build();

        return responseCategoryDto;
    }

    @Override
    public void deleteCategory(long categoryId) {
        Optional<Category> selectedCategory = categoryRepository.findById(categoryId);
        if (selectedCategory.isEmpty()) throw new EntityNotFoundException("Category not found");
        categoryRepository.deleteById(selectedCategory.get().getId());
    }

    @Override
    public PaginateCategoryResponseDto findAllCategories(int page, int size, String searchText) {
        return null;
    }
}
