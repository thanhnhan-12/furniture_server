package com.furniro.furniture.controllers;

import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.Images;
import com.furniro.furniture.models.Product;
import com.furniro.furniture.payload.request.ImageUploadRequest;
import com.furniro.furniture.repositories.ProductRepository;
import com.furniro.furniture.services.image.ImageService;
import com.furniro.furniture.services.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/images")
@AllArgsConstructor
public class ImageUploadController {

//    private ImageService<Images> imageService;
//    private ProductService productService;
//    private ProductRepository productRepository;
//
//    @PostMapping("/uploadImage")
//    public ResponseEntity uploadFiles(
//            @RequestParam("productID") int productID,
//            @RequestParam("files") MultipartFile[] imageFiles) {
//        Product product = productRepository.findById(productID).orElse(null);
//
//        if (product == null) {
//            throw new ResourceNotFoundException("ProductID is not found");
//        }
//
//        imageService.uploadImage(imageFiles, productID);
//
//        return ResponseEntity.ok("Files uploaded successfully!");
//    }
}
