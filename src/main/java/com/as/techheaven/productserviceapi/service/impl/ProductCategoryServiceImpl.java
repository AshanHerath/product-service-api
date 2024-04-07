package com.as.techheaven.productserviceapi.service.impl;

import com.as.techheaven.productserviceapi.dto.paginate.PaginateCategoryResponseDto;
import com.as.techheaven.productserviceapi.dto.request.RequestCategoryDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseCategoryDto;
import com.as.techheaven.productserviceapi.entity.Category;
import com.as.techheaven.productserviceapi.repo.CategoryRepository;
import com.as.techheaven.productserviceapi.service.ProductCategoryService;
import com.as.techheaven.productserviceapi.util.mapper.ProductCategoryMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductCategoryMapper categoryMapper;

    @Override
    public void createCategory(RequestCategoryDto dto) {
        Category category = Category.builder()
                .name(dto.getName())
                .build();
        categoryRepository.save(category);
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
        return categoryMapper.toResponseCategoryDto(selectedCategory.get());
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
