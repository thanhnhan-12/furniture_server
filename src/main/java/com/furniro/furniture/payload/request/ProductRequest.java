package com.furniro.furniture.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    @NotBlank(message = "firstName is a required field.")
    private String productName;

    @NotBlank(message = "lastName is a required field.")
    private String description;

    @NotNull(message = "wardID is not empty")
    private double price;

//    @NotBlank(message = "Address Name is not empty")
//    private String addressName;

}
