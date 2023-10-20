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
public class CartServiceImp implements CartService<Cart> {

    private UserService userService;
    private CartRepository cartRepository;
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<CartDto> getAllCart() {
        User userID = (User) userService.getUserLogin();
        return cartRepository.getAllCart(userID.getUserID());
    }

    @Override
    public List<CartDto> getCartByUser() {
        User userID = (User) userService.getUserLogin();
        return cartRepository.getCartByUser(userID.getUserID());
    }

    @Override
    public List<CartDto> findCartByID(int cartID) {
        return null;
    }

    @Override
    public Cart createCart(CartRequest cartRequest) {
        User user = (User) userService.getUserLogin();
        Product product = productRepository.findById(cartRequest.getProductID()).orElse(null) ;
        if(product == null ) {
            throw new ResourceNotFoundException("ProductID is not found");
        }
        Cart cartFound = this.existCart(user.getUserID(), product.getProductID());

        System.out.println("cartFound" + cartFound);
        Cart cart = new Cart();

        if(cartFound != null) {
            cartFound.setUser(user);
            cartFound.setQuantity(cartFound.getQuantity() + cartRequest.getQuantity());
            cartFound.setProduct(product);
            return cartRepository.save(cartFound);
        }

        cart.setUser(user);
        cart.setQuantity(1);
        cart.setProduct(product);

        return cartRepository.save(cart);
    }

    @Override
    public Cart existCart(int userID, int productID) {
        return cartRepository.existCart(userID, productID);
    }

    @Override
    public void deleteCartByID(int cartID) {
        cartRepository.deleteById(cartID);
    }

    @Override
    public Cart updateCart(int quantity, int cartID) {
        Cart cart = cartRepository.findById(cartID).orElse(null);

        if(cart != null) {
            cart.setQuantity(cart.getQuantity() + quantity);
        }
        return cartRepository.save(cart);
    }

    @Override
    public List<CartDto> clearCart(List<Integer> cartIDs) {
        User userID = (User) userService.getUserLogin();

        // Xoá các sản phẩm trong giỏ hàng
        cartRepository.clearCart(cartIDs);

        // Sau khi xóa, bạn có thể cần trả về danh sách cập nhật hoặc null tùy vào logic của ứng dụng.
        return cartRepository.getAllCart(userID.getUserID());

    }
}
