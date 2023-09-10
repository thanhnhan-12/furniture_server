package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.CategoryDto;
import com.furniro.furniture.models.Category;
import com.furniro.furniture.services.category.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {

    private CategoryService<Category> categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> categoryList = categoryService.getAllCategory();
        if (categoryList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(categoryList);
        }
    }

}
