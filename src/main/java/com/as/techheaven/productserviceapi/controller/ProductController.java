package com.as.techheaven.productserviceapi.controller;

import com.as.techheaven.productserviceapi.dto.request.RequestProductDto;
import com.as.techheaven.productserviceapi.service.ProductService;
import com.as.techheaven.productserviceapi.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<StandardResponse> createProduct(@RequestBody RequestProductDto requestProductDto){
        productService.createProduct(requestProductDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Product was saved!", requestProductDto.getName()), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findProduct(@PathVariable long id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Id no."+id+" Product data found!", productService.findProduct(id)), HttpStatus.OK
        );
    }

    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateProduct(@RequestParam long id, @RequestBody RequestProductDto requestProductDto
    ){
        productService.updateProduct(id,requestProductDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Id no."+id+" Product updated!", requestProductDto.getName()), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Id no."+id+" Product deleted!",id), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(path = "/list", params = {"page", "size", "searchText"})
    public ResponseEntity<StandardResponse> findAllProducts(@RequestParam int page, @RequestParam int size, @RequestParam String searchText){
        return new ResponseEntity<>(
                new StandardResponse(200,"Products data List!", productService.findAllProducts(page, size, searchText)), HttpStatus.OK
        );
    }

}
