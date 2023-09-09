package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.CartDto;
import com.furniro.furniture.models.Cart;
import com.furniro.furniture.models.Product;
import com.furniro.furniture.models.User;
import com.furniro.furniture.services.cart.CartServiceImp;
import com.furniro.furniture.services.product.ProductServiceImp;
import com.furniro.furniture.services.user.UserServiceImp;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {

    private CartServiceImp<Cart, User> cartService;
    private UserServiceImp<User> userService;
    private ProductServiceImp<Product> productService;

    @PostMapping
    public ResponseEntity createCart(@Valid @RequestBody CartDto cartDto) {
//        Cart cartNew = new Cart();
//        cartNew.setCartID(cartDto.getCartID());
//
//        try {
//            Cart createdCart = cartService.createCart(cartNew);
//
//            if (createdCart != null) {
//                return ResponseEntity.status(HttpStatus.CREATED).body(createdCart);
//            } else {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }

        return null;
    }

}
