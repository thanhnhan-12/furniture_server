package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.ProductDto;
import com.furniro.furniture.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsById(int productID);

    @Query(value = "Select p.productid as productID ,p.product_name AS productName, p.description, p.price, p.quantity as quantity, p.categoryid as categoryID," +
            " MAX(i.name_image) AS nameImage \n" +
            "FROM product as p, images as i\n" +
            "where p.productid = i.productid \n" +
            "group by p.productid", nativeQuery = true)
    List<ProductDto> getAllProduct();

}
