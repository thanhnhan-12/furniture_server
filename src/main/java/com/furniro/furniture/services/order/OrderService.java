package com.furniro.furniture.services.order;

import com.furniro.furniture.dto.OrderAdminDto;
import com.furniro.furniture.dto.OrderDto;
import com.furniro.furniture.dto.OrderUserDto;
import com.furniro.furniture.payload.request.OrderRequest;

import java.util.List;

public interface OrderService<O> {

    List<OrderAdminDto> getAllOrders();

    List<OrderUserDto> getOrderByUser(int userID);

    O createOrder(OrderDto orderDto);

    O existOrder(int userID, int orderID);

    void deleteOrderByID(int orderID);
}
