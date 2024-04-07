package com.as.techheaven.productserviceapi.util.mapper;

import com.as.techheaven.productserviceapi.dto.request.RequestBrandDto;
import com.as.techheaven.productserviceapi.dto.request.RequestCategoryDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseBrandDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseCategoryDto;
import com.as.techheaven.productserviceapi.entity.Brand;
import com.as.techheaven.productserviceapi.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductBrandMapper {

    ResponseBrandDto toResponseBrandDto(Brand brand);
    Brand toBrand(RequestBrandDto dto);
    List<ResponseBrandDto> toResponseBrandDtoList(List<Brand> list);

}
