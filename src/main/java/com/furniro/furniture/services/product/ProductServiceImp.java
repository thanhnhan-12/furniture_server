package com.furniro.furniture.services.product;


import com.furniro.furniture.dto.ProductDto;
import com.furniro.furniture.dto.ProductDtoMapper;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.mapper.ProductMapper;
import com.furniro.furniture.models.Product;
import com.furniro.furniture.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService<Product> {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Override
    public Product createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.getAllProduct() ;
    }

    @Override
    public ProductDtoMapper findProductByID(int productID) {
        Product product =  productRepository.findById(productID).orElse(null);
        System.out.println("Quantity: " + product.getQuantity() );
        if(product == null) {
            throw new ResourceNotFoundException("Product not found");
        }

        return productMapper.mapToProduct(product);
    }

    @Override
    public List<ProductDto> existByProductList(int productID, Product product) {
        return productRepository.getAllProduct();
    }
}
