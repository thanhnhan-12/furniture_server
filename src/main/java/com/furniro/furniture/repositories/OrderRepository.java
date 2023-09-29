package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.OrderDto;
import com.furniro.furniture.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

//    @Query(value = "", nativeQuery = true)
//    List<OrderDto> getOrders();

    @Query(value = "Select * from orders as O where O.userid = :userID and O.orderid = :orderID ", nativeQuery = true)
    Orders existOrder(@Param("userID") int userID, @Param("orderID") int orderID);

}
