package com.furniro.furniture.services.category;

import com.furniro.furniture.dto.CategoryDto;
import com.furniro.furniture.models.Category;
import com.furniro.furniture.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService implements CategoryServiceImp<Category> {

    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategory() {
        return categoryRepository.getAllCategory();
    }

    @Override
    public List<CategoryDto> existByCategoryList(int categoryID, Category category) {
        return categoryRepository.getAllCategory();
    }
}
