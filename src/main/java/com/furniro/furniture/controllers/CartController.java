package com.furniro.furniture.controllers;

import com.furniro.furniture.models.Cart;
import com.furniro.furniture.models.Product;
import com.furniro.furniture.models.User;
import com.furniro.furniture.payload.request.CartRequest;
import com.furniro.furniture.services.cart.CartService;
import com.furniro.furniture.services.product.ProductService;
import com.furniro.furniture.services.user.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {

    private CartService<Cart, User> cartService;
    private UserService<User> userService;
    private ProductService<Product> productService;

    @PostMapping
    public ResponseEntity createCart(@Valid @RequestBody CartRequest cartRequest) {
        System.out.println(cartRequest.getProductID());
        return ResponseEntity.ok(cartService.createCart(cartRequest));
    }

}
