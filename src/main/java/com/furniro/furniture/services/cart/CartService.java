package com.furniro.furniture.services.cart;

import com.furniro.furniture.dto.CartDto;
import com.furniro.furniture.models.Cart;
import com.furniro.furniture.models.User;
import com.furniro.furniture.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements CartServiceImp<Cart, User> {

    private CartRepository cartRepository;

    @Override
    public List<CartDto> getAllCarts() {
        return null;
    }

    @Override
    public List<CartDto> findCartByID(int cartID) {
        return null;
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public int deleteCartByID(int cartID) {
        return 0;
    }
}
