package com.furniro.furniture.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartUpdate {
    @NotNull(message = "Quantity is not empty")
    private int quantity;

    @NotNull(message = "cartID is not empty")
    private int cartID;

}
