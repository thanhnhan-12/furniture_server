package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.OrderAdminDto;
import com.furniro.furniture.dto.OrderDto;
import com.furniro.furniture.dto.OrderUserDto;
import com.furniro.furniture.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query(value = "SELECT MAX(Os.orderid) as orderID, MAX(Os.created_at) as createdAt, MAX(Os.status) as status," +
            "MAX(Os.total_price) as totalPrice, MAX(Os.accept_date) as acceptDate,\n" +
            "MAX(Od.quantity) as quantity, \n" +
            "Us.userid as userID, Us.first_name as firstName, Us.last_name as lastName, \n" +
            "MAX(Ad.address_name)\n" +
            "FROM Orders as Os, order_detail as Od, user as Us, address as Ad\n" +
            "where Os.userid = Us.userid and Os.addressid = Ad.addressid\n" +
            "group by Us.userid", nativeQuery = true)
    List<OrderAdminDto> getAllOrders();

//    @Query(value = "", nativeQuery = true)
//    List<OrderUserDto> getOrderByUser(@Param("userID") int userID);

    @Query(value = "Select * from orders as O where O.userid = :userID and O.orderid = :orderID ", nativeQuery = true)
    Orders existOrder(@Param("userID") int userID, @Param("orderID") int orderID);

}
