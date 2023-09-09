package com.furniro.furniture.services.product;

import com.furniro.furniture.dto.ProductDto;
import com.furniro.furniture.models.Product;

import java.util.List;

public interface ProductServiceImp<P> {
    List<ProductDto> getAllProducts();

    List<ProductDto> findProductByID(int productID);

    List<ProductDto> existByProductList(int productID , Product product);

}
