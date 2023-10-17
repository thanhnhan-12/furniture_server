package com.furniro.furniture.dto;

import java.time.LocalDateTime;

public interface OrderAdminDto {
    int getOrderID();
    LocalDateTime getAcceptDate();
    LocalDateTime getCreatedAt();
    String getAddressName();
    boolean getStatus();
    double getTotalPrice();
    int getQuantity();
    int getUserID();
    String getFirstName();
    String getLastName();

}
