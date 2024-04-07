package com.as.techheaven.productserviceapi.service.impl;

import com.as.techheaven.productserviceapi.dto.request.RequestSpecificationTitleDto;
import com.as.techheaven.productserviceapi.dto.response.ResponseSpecificationTitlrDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCategoryAspectsServiceImpl {

    private final WebClient webClient;

    @CircuitBreaker(name = "CategoryService", fallbackMethod = "fallbackMethod")
    public List<RequestSpecificationTitleDto> saveSpecifications(List<RequestSpecificationTitleDto> specifications) {
        return webClient.post().uri("http://localhost:8082/api/v1/specifications/saveList")
                .bodyValue(specifications)
                .retrieve()
                .bodyToFlux(RequestSpecificationTitleDto.class)
                .collectList()
                .block();
    }

    @CircuitBreaker(name = "CategoryService", fallbackMethod = "fallbackMethod")
    public List<ResponseSpecificationTitlrDto> getSpecificationsByCategoryId(long categoryId) {
        return webClient.get().uri("http://localhost:8082/api/v1/specifications/byCategory/{categoryId}", categoryId)
                .retrieve()
                .bodyToFlux(ResponseSpecificationTitlrDto.class)
                .collectList()
                .block();
    }

    public List<ResponseSpecificationTitlrDto> fallbackMethod(long categoryId, Throwable throwable) {
        return Collections.emptyList();
    }


}
