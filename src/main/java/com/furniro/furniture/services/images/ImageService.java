package com.furniro.furniture.services.images;

import com.furniro.furniture.models.Images;

import java.util.List;

public interface ImageService<I> {
    List<Images> getImages();

    boolean existByImageList(int imageID , Images images);

}
