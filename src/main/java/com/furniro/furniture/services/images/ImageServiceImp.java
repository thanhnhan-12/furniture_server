package com.furniro.furniture.services.images;

import com.furniro.furniture.models.Images;
import com.furniro.furniture.repositories.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ImageServiceImp implements ImageService<Images> {

    private ImageRepository imageRepository;

    @Override
    public List<Images> getImages() {
        return imageRepository.findAll();
    }

    @Override
    public boolean existByImageList(int imageID, Images images) {
        return imageRepository.existsById(imageID) ;
    }
}
