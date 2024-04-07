package com.as.techheaven.productserviceapi.service;

import com.as.techheaven.productserviceapi.dto.paginate.PaginateCategoryResponseDto;
import com.as.techheaven.productserviceapi.dto.request.RequestCategoryDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseCategoryDto;

public interface ProductCategoryService {

    public void createCategory(RequestCategoryDto dto);
    public void updateCategory(long categoryId, RequestCategoryDto dto);
    public ResponseCategoryDto findCategory(long categoryId);
    public void deleteCategory(long categoryId);
    public PaginateCategoryResponseDto findAllCategories(int page, int size, String searchText);

}
