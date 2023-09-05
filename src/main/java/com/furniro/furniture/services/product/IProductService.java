package com.furniro.furniture.services.product;

import com.furniro.furniture.dto.ProductDto;
import com.furniro.furniture.models.Product;

import java.util.List;

public interface IProductService<P> {
    List<ProductDto> getAllProducts();

//    P getProductByID(int productID);

    List<ProductDto> existByProductList(int productID , Product product);

}
