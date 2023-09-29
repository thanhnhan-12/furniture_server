package com.furniro.furniture.services.order;

import com.furniro.furniture.constants.MessageEnum;
import com.furniro.furniture.dto.OrderDto;
import com.furniro.furniture.dto.OrderRequestDto;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.*;
import com.furniro.furniture.payload.request.OrderRequest;
import com.furniro.furniture.repositories.CartRepository;
import com.furniro.furniture.repositories.OrderRepository;
import com.furniro.furniture.repositories.ProductRepository;
import com.furniro.furniture.repositories.UserRepository;
import com.furniro.furniture.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService<Orders> {

    private UserService userService;
    private OrderRepository orderRepository;
    private CartRepository cartRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @Override
    public List<OrderDto> getOrders() {
        return null;
    }

    @Override
    public Orders createOrder(OrderDto orderDto) {
        int totalPrice = 0;
        Orders order = new Orders();
        Address address = new Address();
        List<OrderDetail> orderItemList = new ArrayList<>();

        User user = userRepository.findById(Math.toIntExact(orderDto.getUserID())).orElse(null);
        List<OrderRequestDto> orderItems = orderDto.getOrderItems();

        if (orderItems != null && orderItems.size() > 0) {
            for (OrderRequestDto item : orderItems) {
                OrderDetail orderItem = new OrderDetail();

                Optional<Product> productOptional = productRepository.findById(Math.toIntExact(item.getProductID()));
                if (productOptional.isPresent()) {
                    Product product = productOptional.get();
                    totalPrice += product.getPrice() * item.getQuantity();
                    orderItem.setProduct(product);
                    orderItem.setQuantity(item.getQuantity());
                    orderItem.setOrders(order);
                    orderItemList.add(orderItem);
                } else {
                    throw new ResourceNotFoundException(
                            MessageEnum.NOT_FOUND.getFormattedMessage("product", item.getProductID()));
                }
            }
        }

        order.setOrderDetails(orderItemList);
        order.setTotalPrice(totalPrice);
        order.setUser(user);
        address.setAddressID(orderDto.getAddressID());
        order.setAddress(address);

        orderRepository.save(order);

        return (Orders) order;
    }

    @Override
    public Orders existOrder(int userID, int orderID) {
        return orderRepository.existOrder(userID, orderID);
    }

    @Override
    public void deleteOrderByID(int orderID) {

    }
}
