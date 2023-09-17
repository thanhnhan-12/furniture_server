package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.CartDto;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.Cart;
import com.furniro.furniture.models.Product;
import com.furniro.furniture.models.User;
import com.furniro.furniture.payload.request.CartRequest;
import com.furniro.furniture.payload.request.CartUpdate;
import com.furniro.furniture.services.cart.CartService;
import com.furniro.furniture.services.product.ProductService;
import com.furniro.furniture.services.user.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/cart")
@AllArgsConstructor
public class CartController {

    private CartService<Cart> cartService;
    private UserService<User> userService;
    private ProductService<Product> productService;

    @GetMapping
    public ResponseEntity<List<CartDto>> getCartByUser() {
//        System.out.println("UserID: " + userID.getUserID());
        List<CartDto> userCartList = cartService.getCartByUser();
            return ResponseEntity.ok(userCartList);
    }

    @PostMapping("/createCart")
    public ResponseEntity createCart(@Valid @RequestBody CartRequest cartRequest) {
        System.out.println(cartRequest.getProductID());
        return ResponseEntity.ok(cartService.createCart(cartRequest));
    }

    @PutMapping("/updateCart")
    public ResponseEntity updateCart(@Valid @RequestBody CartUpdate cartUpdate) {
        System.out.println("Quantity: " + cartUpdate.getQuantity() );
        System.out.println("CartID: " + cartUpdate.getCartID() );

        return ResponseEntity.ok(cartService.updateCart(cartUpdate.getQuantity(), cartUpdate.getCartID()));
    }

    @DeleteMapping("/{cartID}")
    public ResponseEntity<String> deleteCartByID(@PathVariable int cartID) {
        cartService.deleteCartByID(cartID);
        return ResponseEntity.ok("Cart with ID " + cartID + " has been deleted.");
    }
}
