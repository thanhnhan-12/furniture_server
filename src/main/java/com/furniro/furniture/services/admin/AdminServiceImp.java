package com.furniro.furniture.services.admin;

import com.furniro.furniture.dto.MonthlyRevenueDto;
import com.furniro.furniture.dto.ProductSellingDto;
import com.furniro.furniture.dto.UserAdminDto;
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
}
