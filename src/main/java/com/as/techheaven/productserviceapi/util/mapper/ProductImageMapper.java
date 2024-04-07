package com.as.techheaven.productserviceapi.util.mapper;

import com.as.techheaven.productserviceapi.dto.request.RequestBrandDto;
import com.as.techheaven.productserviceapi.dto.request.RequestProductImageDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseBrandDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseProductImageDto;
import com.as.techheaven.productserviceapi.entity.Brand;
import com.as.techheaven.productserviceapi.entity.ProductImage;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductImageMapper {

    ResponseProductImageDto toResponseImageDto(ProductImage productImage);
    ProductImage toImage(RequestProductImageDto dto);
    List<ResponseProductImageDto> toResponseImageDtoList(List<ProductImage> list);

}
