package com.furniro.furniture.services.cart;

import com.furniro.furniture.dto.CartDto;
import com.furniro.furniture.payload.request.CartRequest;

import java.util.List;

public interface CartService<C, U> {

    List<CartDto> getAllCarts();

    List<CartDto> findCartByID(int cartID);

    C createCart(CartRequest cartRequest);

    int deleteCartByID(int cartID);
}
