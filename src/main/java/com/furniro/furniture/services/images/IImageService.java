package com.furniro.furniture.services.images;

import com.furniro.furniture.models.Images;
import com.furniro.furniture.models.Product;

import java.util.List;

public interface IImageService<I> {
    List<Images> getImages();

    boolean existByImageList(int imageID , Images images);

}
