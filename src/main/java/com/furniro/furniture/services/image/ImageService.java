package com.furniro.furniture.services.image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService<I> {
    void uploadImage(MultipartFile[] imageFiles, int productID);
}
