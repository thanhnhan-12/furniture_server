package com.furniro.furniture.controllers;

import com.furniro.furniture.payload.request.UploadImageRequest;
import com.furniro.furniture.services.uploadimage.UploadImageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.ModelAttribute;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/images")
@AllArgsConstructor
public class UploadImageController {

    private UploadImageService uploadImageService;

    @PostMapping("/uploadImage")
    public ResponseEntity uploadImage(@ModelAttribute("imageFiles") MultipartFile[] imageFiles, @Valid @ModelAttribute UploadImageRequest uploadImageRequest) {
        System.out.println("productID: " + uploadImageRequest.getProductID());
        try {
            uploadImageService.uploadImage(imageFiles, uploadImageRequest);
            System.out.println("Upload Image" + imageFiles);
            System.out.println("productID: " + uploadImageRequest.getProductID());
            return ResponseEntity.ok("Images uploaded successfully.");
        } catch (Exception e) {
            return ResponseEntity.ok("Failed to upload image");
        }

    }

}
