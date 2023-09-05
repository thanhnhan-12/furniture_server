package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.CategoryDto;
import com.furniro.furniture.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    boolean existsById(int categoryID);

    @Query(value = "SELECT c.categoryid as categoryID, c.category_img as categoryImg, c.category_name as categoryName, c.maxim as maxim FROM category c ", nativeQuery = true)
    List<CategoryDto> getAllCategory();

}
