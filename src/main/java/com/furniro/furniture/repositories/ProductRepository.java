package com.furniro.furniture.repositories;

import com.furniro.furniture.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    boolean existsById(int productID);



}
