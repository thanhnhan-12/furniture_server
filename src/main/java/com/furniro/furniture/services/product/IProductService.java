package com.furniro.furniture.services.product;

import com.furniro.furniture.models.Product;

import java.util.List;

public interface IProductService<P> {
    List<Product> getAllProducts();

//    P getProductByID(int productID);

    boolean existByProductList(int productID ,Product product);

}
