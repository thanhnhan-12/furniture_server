package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.*;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.Orders;
import com.furniro.furniture.services.admin.AdminService;
import com.furniro.furniture.services.order.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/searchProductName", method = RequestMethod.GET)
    public ResponseEntity searchProductName( @RequestParam(value = "productName", required = false) String productName) {
        List<SearchProductNameDto> productNameDto = adminService.searchProductName(productName);
        System.out.println("Product Name: " + productName);

        if(productNameDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product Name not found");
        } else {
            return ResponseEntity.ok(productNameDto);
        }
    }

    @RequestMapping(value = "/searchUser", method = RequestMethod.GET)
    public ResponseEntity searchUser( @RequestParam(value = "firstName", required = false) String firstName,
                                      @RequestParam(value = "lastName", required = false) String lastName,
                                      @RequestParam(value = "email", required = false) String email,
                                      @RequestParam(value = "phoneNumber", required = false) String phoneNumber) {
        List<SearchUserInforDto> userInfor = adminService.searchUserInfor(firstName, lastName, email, phoneNumber);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);

        if(userInfor.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User information not found");
        } else {
            return ResponseEntity.ok(userInfor);
        }
    }

}
