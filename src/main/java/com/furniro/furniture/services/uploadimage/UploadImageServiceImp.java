package com.furniro.furniture.services.uploadimage;

import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.Images;
import com.furniro.furniture.models.Product;
import com.furniro.furniture.payload.request.UploadImageRequest;
import com.furniro.furniture.repositories.ImageRepository;
import com.furniro.furniture.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UploadImageServiceImp implements UploadImageService<Images>  {

    private ProductRepository productRepository;

    private ImageRepository imageRepository;

    @Autowired
    private ConfigImage appConfig;

    @Transactional
    @Override
    public List<Images> uploadImage(MultipartFile[] imageFiles, UploadImageRequest uploadImageRequest) {
        String uploadPath = appConfig.getUploadPath();

        String path = System.getProperty("user.dir");
        System.out.println("Path: " + path);

        uploadPath = path + "\\" + uploadPath;

        Product product = productRepository.findById(uploadImageRequest.getProductID())
                .orElseThrow(() -> new ResourceNotFoundException("ProductID not found: " + uploadImageRequest.getProductID()));

        List<Images> uploadedImages = new ArrayList<>();

        for (MultipartFile file : imageFiles) {
            // Lưu file vào thư mục
            String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());

            if (!originalFilename.isEmpty()) {
                try {
                    // Đảm bảo thư mục upload tồn tại
                    File uploadDirectory = new File(uploadPath);
                    if (!uploadDirectory.exists()) {
                        uploadDirectory.mkdirs();
                        System.out.println("Directory: " + uploadDirectory);
                    }
                    // Tạo tên file mới
                    String newFilename = System.currentTimeMillis() + originalFilename;
                    File uploadedFile = new File(uploadPath, newFilename);

                    System.out.println("Đường dẫn tới tệp hình ảnh: " + uploadedFile.getAbsolutePath());

                    // Lưu hình ảnh
                    file.transferTo(uploadedFile);

                    // Lưu thông tin hình ảnh vào cơ sở dữ liệu
                    Images image = new Images();
                    image.setProduct(product);
                    image.setNameImage(newFilename);
                    // Lưu image vào cơ sở dữ liệu (chưa có mã lệnh trong mã nguồn bạn đã cung cấp)

                    Images savedImage = imageRepository.save(image);
                    uploadedImages.add(savedImage);

                } catch (IOException e) {
                    System.out.println("Lỗi khi lưu tệp hình ảnh: " + e.getMessage());
                    throw new ResourceNotFoundException("Failed to upload files.");
                }
            }
        }
        return uploadedImages;
    }
}
