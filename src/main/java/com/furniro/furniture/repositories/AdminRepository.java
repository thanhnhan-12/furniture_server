package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.MonthlyRevenueDto;
import com.furniro.furniture.dto.ProductSellingDto;
import com.furniro.furniture.dto.UserAdminDto;
import com.furniro.furniture.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT Ro.name as roleName, COUNT(*) as totalUsers\n" +
            "FROM user as Us\n" +
            "INNER JOIN user_roles as Ur ON Us.userid = Ur.user_id\n" +
            "INNER JOIN roles as Ro ON Ur.role_id = Ro.roleid\n" +
            "GROUP BY Ro.name;", nativeQuery = true)
    List<UserAdminDto> userStatistics();

    @Query(value = "SELECT Pro.productid as productID, Pro.product_name as productName, COUNT(Od.orderid) as totalSales\n" +
            "FROM product as Pro\n" +
            "LEFT JOIN order_detail as Od ON Pro.productid = Od.productid\n" +
            "GROUP BY Pro.productid, Pro.product_name\n" +
            "ORDER BY totalSales DESC", nativeQuery = true)
    List<ProductSellingDto> bestSellingProducts();

    @Query(value = "SELECT\n" +
            "    DATE_FORMAT(Os.created_at, '%Y-%m') as month,\n" +
            "    SUM(Os.total_price) AS totalRevenue\n" +
            "FROM orders as Os\n" +
            "GROUP BY DATE_FORMAT(Os.created_at, '%Y-%m')\n" +
            "ORDER BY month", nativeQuery = true)
    List<MonthlyRevenueDto> monthlyRevenueStatistics();

}
