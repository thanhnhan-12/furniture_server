package com.furniro.furniture.services.category;

import com.furniro.furniture.dto.CategoryDto;
import com.furniro.furniture.models.Category;

import java.util.List;

public interface CategoryService<C> {
    List<CategoryDto> getAllCategory();

    List<CategoryDto> existByCategoryList(int categoryID, Category category);
}
