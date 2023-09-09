package com.furniro.furniture.services.product;

import com.furniro.furniture.dto.ProductDto;
import com.furniro.furniture.models.Product;
import com.furniro.furniture.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService implements ProductServiceImp<Product> {

    private ProductRepository productRepository;

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.getAllProduct() ;
    }

    @Override
    public List<ProductDto> findProductByID(int productID) {
        return productRepository.findById(productID);
    }

    @Override
    public List<ProductDto> existByProductList(int productID, Product product) {
        return productRepository.getAllProduct();
    }
}
