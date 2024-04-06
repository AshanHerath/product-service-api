package com.as.techheaven.productserviceapi.controller;

import com.as.techheaven.productserviceapi.dto.request.RequestCategoryDto;
import com.as.techheaven.productserviceapi.service.ProductCategoryService;
import com.as.techheaven.productserviceapi.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService categoryService;

    @PostMapping
    public ResponseEntity<StandardResponse> createCategory(@RequestBody RequestCategoryDto requestCategoryDto){
        categoryService.createCategory(requestCategoryDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Category was saved!", requestCategoryDto.getName()), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findCategory(@PathVariable long id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Id no."+id+" Category data found!", categoryService.findCategory(id)), HttpStatus.OK
        );
    }

    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateCategory(@RequestParam long id, @RequestBody RequestCategoryDto requestCategoryDto
    ){
        categoryService.updateCategory(id, requestCategoryDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Id no."+id+" Product updated!", requestCategoryDto.getName()), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteCategory(@PathVariable long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Id no."+id+" Category deleted!",id), HttpStatus.NO_CONTENT
        );
    }

}
