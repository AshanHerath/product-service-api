package com.as.techheaven.productserviceapi.util.mapper;

import com.as.techheaven.productserviceapi.dto.request.RequestProductDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseProductDto;
import com.as.techheaven.productserviceapi.entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ResponseProductDto toResponseProductDto(Product product);
    Product toProduct(RequestProductDto dto);
    List<ResponseProductDto> toResponseProductDtoList(List<Product> list);

}
