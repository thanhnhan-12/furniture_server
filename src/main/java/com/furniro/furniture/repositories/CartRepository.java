package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.CartDto;
import com.furniro.furniture.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "Select Us.userid, Prod.productid, Prod.product_name, Prod.price, MAX(Img.name_image), Ca.cartid, Ca.quantity\n" +
            "From user as Us, product as Prod, images as Img, cart as Ca\n" +
            "where Us.userid = :userID and Prod.productid = Img.productid and Prod.productid = Ca.productid\n" +
            "Group by Us.userid, Prod.productid, Ca.cartid", nativeQuery = true)
    List<CartDto> getAllCart(@Param("userID") int userID );

    @Query(value = "SELECT Us.userid, Prod.productid,\n" +
            "    MAX(Prod.product_name) AS product_name,\n" +
            "    MAX(Prod.price) AS price,\n" +
            "    MAX(Img.name_image) AS name_image,\n" +
            "    MAX(Ca.cartid) AS cartid,\n" +
            "    SUM(Ca.quantity) AS total_quantity\n" +
            "FROM user AS Us\n" +
            "JOIN product AS Prod ON Us.userid = :userID\n" +
            "JOIN images AS Img ON Prod.productid = Img.productid\n" +
            "JOIN cart AS Ca ON Prod.productid = Ca.productid\n" +
            "GROUP BY Us.userid, Prod.productid;", nativeQuery = true)
    List<CartDto> getCartByUser(@Param("userID") int userID);

    @Query(value = "Select Us.userid, Prod.productid, Prod.product_name, Prod.price, Img.name_image, Ca.cartid, Ca.quantity\n" +
            "From user as Us, product as Prod, images as Img, cart as Ca\n" +
            "where Us.userid = 6 and Prod.productid = 1 and Prod.productid = Img.productid and Prod.productid = Ca.productid \n" +
            "Group by Us.userid, Prod.productid, Ca.cartid; ", nativeQuery = true)
    Cart existCart(@Param("userID") int userID, @Param("productID") int productID);

    @Query(value = "Update Cart as Ca set Ca.quantity = :quantity where Ca.cartID = :cartID", nativeQuery = true)
    int updateCart(@Param("quantity") int quantity, @Param("cartID") int cartID );

}
