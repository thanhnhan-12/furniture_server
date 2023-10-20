package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.MonthlyRevenueDto;
import com.furniro.furniture.dto.ProductSellingDto;
import com.furniro.furniture.dto.UserAdminDto;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.Orders;
import com.furniro.furniture.services.admin.AdminService;
import com.furniro.furniture.services.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/v1/admin")
@AllArgsConstructor
public class AdminController {

    AdminService adminService;

    @GetMapping("/userStatistics")
    public ResponseEntity userStatistics() {
        List<UserAdminDto> userListStatistics = adminService.userStatistics();
        if (userListStatistics.isEmpty()) {
            throw new ResourceNotFoundException("Cannot found User List Statistics ");
        } else {
            return ResponseEntity.ok(userListStatistics);
        }
    }

    @GetMapping("/bestSellingProducts")
    public ResponseEntity bestSellingProducts() {
        List<ProductSellingDto> productListSelling = adminService.bestSellingProducts();
        if (productListSelling.isEmpty()) {
            throw new ResourceNotFoundException("Cannot found Product Selling List Statistics ");
        } else {
            return ResponseEntity.ok(productListSelling);
        }
    }

    @GetMapping("/monthlyRevenueStatistics")
    public ResponseEntity monthlyRevenueStatistics() {
        List<MonthlyRevenueDto> monthlyRevenue = adminService.monthlyRevenueStatistics();
        if(monthlyRevenue.isEmpty()) {
            throw new ResourceNotFoundException("Cannot found Monthly Revenue Statistics");
        } else {
            return ResponseEntity.ok(monthlyRevenue);
        }
    }

}
