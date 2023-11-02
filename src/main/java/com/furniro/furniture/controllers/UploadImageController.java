package com.furniro.furniture.controllers;

import com.furniro.furniture.payload.request.UploadImageRequest;
import com.furniro.furniture.services.uploadimage.ConfigImage;
import com.furniro.furniture.services.uploadimage.UploadImageService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/images")
@AllArgsConstructor
public class UploadImageController {

    private UploadImageService uploadImageService;

    @Autowired
    private ConfigImage appConfig;

    @GetMapping("/{nameImage}")
    public ResponseEntity<byte[]> getImage(@PathVariable String nameImage) {
        String uploadPath = appConfig.getUploadPath();

        try {
            Path imagePath = Paths.get(uploadPath, nameImage);
            byte[] imageBytes = Files.readAllBytes(imagePath);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Điều chỉnh kiểu hình ảnh nếu cần
            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Trả về lỗi nếu không tìm thấy hình ảnh
        }
    }

    @RequestMapping(value = "/uploadImage", method = RequestMethod.POST,
            headers = "Accept=multipart/form-data")
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
