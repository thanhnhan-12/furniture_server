package com.furniro.furniture.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    @NotBlank(message = "productName is a required field.")
    private String productName;

    @NotBlank(message = "description is a required field.")
    private String description;

    @NotNull(message = "price is not empty")
    private double price;

    @NotNull(message = "quantity is not empty")
    private int quantity;

    @NotNull(message = "categoryID is not empty")
    private int categoryID;

}
