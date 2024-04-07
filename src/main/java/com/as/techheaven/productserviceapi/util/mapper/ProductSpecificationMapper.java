package com.as.techheaven.productserviceapi.util.mapper;

import com.as.techheaven.productserviceapi.dto.request.RequestBrandDto;
import com.as.techheaven.productserviceapi.dto.request.RequestSpecificationDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseBrandDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseSpecificationDto;
import com.as.techheaven.productserviceapi.entity.Brand;
import com.as.techheaven.productserviceapi.entity.ProductSpecification;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductSpecificationMapper {

    ResponseSpecificationDto toResponseSpecificationDto(ProductSpecification specification);
    ProductSpecification toSpecification(RequestSpecificationDto dto);
    List<ResponseSpecificationDto> toResponseSpecificationDtoList(List<ProductSpecification> list);

}
