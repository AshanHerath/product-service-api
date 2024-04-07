package com.as.techheaven.productserviceapi.util.mapper;

import com.as.techheaven.productserviceapi.dto.request.RequestCategoryDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseCategoryDto;
import com.as.techheaven.productserviceapi.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {

    ResponseCategoryDto toResponseCategoryDto(Category category);
    Category toCategory(RequestCategoryDto dto);
    List<ResponseCategoryDto> toResponseCategoryDtoList(List<Category> list);

}
