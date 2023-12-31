package com.furniro.furniture.services.product;

import com.furniro.furniture.dto.ProductDto;
import com.furniro.furniture.dto.ProductDtoMapper;
import com.furniro.furniture.models.Product;
import com.furniro.furniture.payload.request.ProductRequest;

import java.util.List;

public interface ProductService<P> {
    P addProduct(ProductRequest productRequest);

    List<ProductDto> getAllProducts();

    ProductDtoMapper findProductByID(int productID);

    List<ProductDto> existByProductList(int productID , Product product);

}
