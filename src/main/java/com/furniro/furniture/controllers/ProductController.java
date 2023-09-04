package com.furniro.furniture.controllers;

import com.furniro.furniture.models.Product;
import com.furniro.furniture.services.product.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http:localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {

    private IProductService<Product> productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> productList = productService.getAllProducts();
        if (productList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(productList);
        }
    }

}
