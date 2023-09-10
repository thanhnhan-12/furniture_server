package com.furniro.furniture.services.cart;

import com.furniro.furniture.dto.CartDto;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.Cart;
import com.furniro.furniture.models.Product;
import com.furniro.furniture.models.User;
import com.furniro.furniture.payload.request.CartRequest;
import com.furniro.furniture.repositories.CartRepository;
import com.furniro.furniture.repositories.ProductRepository;
import com.furniro.furniture.services.product.ProductService;
import com.furniro.furniture.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImp implements CartService<Cart, User> {

    private UserService userService;
    private CartRepository cartRepository;
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CartDto> getAllCarts() {
        return null;
    }

    @Override
    public List<CartDto> findCartByID(int cartID) {
        return null;
    }

    @Override
    public Cart createCart(CartRequest cartRequest) {
        Cart cart = new Cart();
        Product product = productRepository.findById(cartRequest.getProductID()).orElse(null) ;
        if(product == null ) {
            throw new ResourceNotFoundException("ProductID is not found");
        }

        System.out.println("User: " + userService.getUserLogin());
        cart.setUser((User) userService.getUserLogin());
        cart.setQuantity(cartRequest.getQuantity());
        cart.setProduct(product);

        return cartRepository.save(cart);
    }

    @Override
    public int deleteCartByID(int cartID) {
        return 0;
    }
}
