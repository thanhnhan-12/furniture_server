package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.OrderDto;
import com.furniro.furniture.models.OrderDetail;
import com.furniro.furniture.models.Orders;
import com.furniro.furniture.payload.request.OrderRequest;
import com.furniro.furniture.services.order.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {

    private OrderService<Orders> orderService;

    @PostMapping("/createOrder")
    public ResponseEntity createOrder(@Valid @RequestBody OrderDto orderDto) {
        List<OrderDetail> orderItemList = (List<OrderDetail>) orderService.createOrder(orderDto);

        return ResponseEntity.ok("Create Order Successfully!");
    }

}
