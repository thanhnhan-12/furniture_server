package com.furniro.furniture.services.uploadimage;

import com.furniro.furniture.payload.request.UploadImageRequest;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface UploadImageService<I> {
    List<I> uploadImage(MultipartFile[] imageFiles, UploadImageRequest uploadImageRequest);
}
