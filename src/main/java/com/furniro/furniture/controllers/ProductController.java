package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.ProductDto;
import com.furniro.furniture.dto.ProductDtoMapper;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.Product;
import com.furniro.furniture.services.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {

    private ProductService<Product> productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProduct() {
        List<ProductDto> productList = productService.getAllProducts();
        if (productList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(productList);
        }
    }

    @GetMapping("/{productID}")
    public ResponseEntity<ProductDtoMapper>  getProductById(@PathVariable int productID) {
        ProductDtoMapper productByID = productService.findProductByID(productID);

        if (productByID == null ) {
            throw new ResourceNotFoundException("ProductID not found") ;
        } else {
            return ResponseEntity.ok(productByID);
        }
    }







}
