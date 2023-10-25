package com.furniro.furniture.services.admin;

import com.furniro.furniture.dto.*;

import java.util.List;

public interface AdminService {
    List<UserAdminDto> userStatistics();

    List<ProductSellingDto> bestSellingProducts();

    List<MonthlyRevenueDto> monthlyRevenueStatistics();

    List<SearchProductNameDto> searchProductName(String productName);

    List<SearchUserInforDto> searchUserInfor(String firstName, String lastName, String email, String phoneNumber);
}
