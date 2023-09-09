package com.furniro.furniture.services.cart;

import com.furniro.furniture.dto.CartDto;

import java.util.List;

public interface CartServiceImp<C, U> {

    List<CartDto> getAllCarts();

    List<CartDto> findCartByID(int cartID);

    C createCart(C cart);

    int deleteCartByID(int cartID);
}
