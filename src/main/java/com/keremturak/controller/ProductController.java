package com.keremturak.controller;

import com.keremturak.dto.request.ProductSaveRequestDto;
import com.keremturak.repository.entity.Product;
import com.keremturak.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import static com.keremturak.constants.RestApiList.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PRODUCT)
public class ProductController {
    private final ProductService productService;

    @PostMapping(SAVE)
    public ResponseEntity<Product> save(@RequestBody @Valid ProductSaveRequestDto dto){
        return ResponseEntity.ok(productService.save(dto));
    }


}
