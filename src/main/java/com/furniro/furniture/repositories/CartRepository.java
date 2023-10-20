package com.furniro.furniture.repositories;

import com.furniro.furniture.dto.CartDto;
import com.furniro.furniture.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query(value = "Select Us.userid, Prod.productid, Prod.product_name, Prod.price, MAX(Img.name_image), Ca.cartid, Ca.quantity\n" +
            "From user as Us, product as Prod, images as Img, cart as Ca\n" +
            "where Us.userid = :userID and Prod.productid = Img.productid and Prod.productid = Ca.productid\n" +
            "Group by Us.userid, Prod.productid, Ca.cartid", nativeQuery = true)
    List<CartDto> getAllCart(@Param("userID") int userID );

    @Query(value = "SELECT Us.userid, Prod.productid as productID, Prod.product_name as productName, Prod.price as price, MAX(Img.name_image) as nameImage, MAX(Ca.cartid) as CartID, MAX(Ca.quantity) as quantity \n" +
            "FROM user AS Us \n" +
            "JOIN cart AS Ca ON Us.userid = Ca.userid \n" +
            "JOIN product AS Prod ON Ca.productid = Prod.productid \n" +
            "JOIN images AS Img ON Prod.productid = Img.productid \n" +
            "WHERE Us.userid = :userID\n" +
            "GROUP BY Us.userid, Prod.productid", nativeQuery = true)
    List<CartDto> getCartByUser(@Param("userID") int userID);

    @Query(value = "Select * from cart as C where C.userid =:userID and C.productid =:productID ", nativeQuery = true)
    Cart existCart(@Param("userID") int userID, @Param("productID") int productID);

    @Query(value = "Update Cart as Ca set Ca.quantity = :quantity where Ca.cartID = :cartID", nativeQuery = true)
    int updateCart(@Param("quantity") int quantity, @Param("cartID") int cartID );

    @Modifying
    @Query(value = "DELETE FROM cart WHERE cartid IN :cartID", nativeQuery = true)
    @Transactional
    void clearCart(@Param("cartID") List<Integer> cartID);

//    void deleteByCartIDIn(List<Integer> cartIDs);

    @Query(value = "SELECT cart.cartID FROM Cart cart WHERE cart.user.userID = :userID")
    List<Integer> findCartIDsByUserID(@Param("userID") int userID);

}
