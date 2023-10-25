package com.furniro.furniture.services.admin;

import com.furniro.furniture.dto.*;
import com.furniro.furniture.repositories.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminServiceImp implements AdminService {

    AdminRepository adminRepository;

    @Override
    public List<UserAdminDto> userStatistics() {
        return adminRepository.userStatistics();
    }

    @Override
    public List<ProductSellingDto> bestSellingProducts() {
        return adminRepository.bestSellingProducts();
    }

    @Override
    public List<MonthlyRevenueDto> monthlyRevenueStatistics() {
        return adminRepository.monthlyRevenueStatistics();
    }

    @Override
    public List<SearchProductNameDto> searchProductName(String productName) {
        return adminRepository.searchProductName(productName);
    }

    @Override
    public List<SearchUserInforDto> searchUserInfor(String firstName, String lastName, String email, String phoneNumber) {
        return adminRepository.searchUserInfor(firstName, lastName, email, phoneNumber);
    }
}
