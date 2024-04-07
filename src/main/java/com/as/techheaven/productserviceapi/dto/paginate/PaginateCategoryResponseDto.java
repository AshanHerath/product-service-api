package com.as.techheaven.productserviceapi.dto.paginate;

import com.as.techheaven.productserviceapi.dto.response.ResponseCategoryDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginateCategoryResponseDto {

    private long count;
    private List<ResponseCategoryDto> dataList;

}
