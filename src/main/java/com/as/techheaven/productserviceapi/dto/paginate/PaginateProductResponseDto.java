package com.as.techheaven.productserviceapi.dto.paginate;

import com.as.techheaven.productserviceapi.dto.response.ResponseProductDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaginateProductResponseDto {

    private long count;
    private List<ResponseProductDto> dataList;

}
