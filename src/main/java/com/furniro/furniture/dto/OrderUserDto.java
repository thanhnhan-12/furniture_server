package com.furniro.furniture.dto;

import java.time.LocalDateTime;

public interface OrderUserDto {
    int getOrderID();
    LocalDateTime getCreatedAt();
    int getAddressID();
    String getAddressName();
    int getWardID();
    boolean getStatus();
    double getTotalPrice();
    int getUserID();
    int getQuantity();
    int getProductID();
}
