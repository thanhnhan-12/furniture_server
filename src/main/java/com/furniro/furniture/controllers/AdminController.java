package com.furniro.furniture.controllers;

import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.Orders;
import com.furniro.furniture.services.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController {


}
