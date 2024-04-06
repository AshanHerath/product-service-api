package com.as.techheaven.productserviceapi.controller;

import com.as.techheaven.productserviceapi.dto.request.RequestBrandDto;
import com.as.techheaven.productserviceapi.service.ProductBrandService;
import com.as.techheaven.productserviceapi.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brands")
@RequiredArgsConstructor
public class ProductBrandController {

    private final ProductBrandService productBrandService;

    @PostMapping
    public ResponseEntity<StandardResponse> createBrand(@RequestBody RequestBrandDto requestBrandDto){
        productBrandService.createBrand(requestBrandDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Brand was saved!", requestBrandDto.getName()), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findBrand(@PathVariable long id){
        return new ResponseEntity<>(
                new StandardResponse(200,"Id no."+id+" Brand data found!", productBrandService.findBrand(id)), HttpStatus.OK
        );
    }

    @PutMapping(params = "id")
    public ResponseEntity<StandardResponse> updateBrand(@RequestParam long id, @RequestBody RequestBrandDto requestBrandDto
    ){
        productBrandService.updateBrand(id, requestBrandDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"Id no."+id+" Brand updated!", requestBrandDto.getName()), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> deleteBrand(@PathVariable long id){
        productBrandService.deleteBrand(id);
        return new ResponseEntity<>(
                new StandardResponse(204,"Id no."+id+" Brand deleted!",id), HttpStatus.NO_CONTENT);


    }
}
