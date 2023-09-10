package com.furniro.furniture.dto;

import com.furniro.furniture.models.Images;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@AllArgsConstructor
public class ProductDtoMapper {
    private int productID;

    private String productName;
    private String description;
    private double price;
    List<Images> imagesList;

}
