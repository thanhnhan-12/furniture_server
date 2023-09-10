package com.furniro.furniture.controllers;

import com.furniro.furniture.models.Images;
import com.furniro.furniture.services.images.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http:localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/images")
@AllArgsConstructor
public class ImageController {

    private ImageService<Images> imageService;

    @GetMapping
    public ResponseEntity<List<Images>> getImage() {
        List<Images> imagesList = imageService.getImages();
        if (imagesList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(imagesList);
        }
    }

}
