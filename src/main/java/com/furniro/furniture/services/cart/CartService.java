package com.furniro.furniture.services.cart;

import com.furniro.furniture.dto.CartDto;
import com.furniro.furniture.payload.request.CartRequest;

import java.util.List;

public interface CartService<C> {

    List<CartDto> getAllCart();

    List<CartDto> getCartByUser();

    List<CartDto> findCartByID(int cartID);

    C createCart(CartRequest cartRequest);

    C existCart(int userID, int productID);

    void deleteCartByID(int cartID);

    C updateCart(int quantity, int cartID);

    List<CartDto> clearCart(List<Integer> cartIDs);

}
