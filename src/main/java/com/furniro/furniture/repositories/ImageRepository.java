package com.furniro.furniture.repositories;

import com.furniro.furniture.models.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Images, Integer> {
    boolean existsById(int imageID);

}
