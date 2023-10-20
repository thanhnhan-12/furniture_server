package com.furniro.furniture.services.admin;

import com.furniro.furniture.dto.MonthlyRevenueDto;
import com.furniro.furniture.dto.ProductSellingDto;
import com.furniro.furniture.dto.UserAdminDto;

import java.util.List;

public interface AdminService {
    List<UserAdminDto> userStatistics();

    List<ProductSellingDto> bestSellingProducts();

    List<MonthlyRevenueDto> monthlyRevenueStatistics();
}
