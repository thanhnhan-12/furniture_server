package com.furniro.furniture.dto;

public interface CartDto {

    int getCartID();
    int getProductID();
    int getUserID();
    int getQuantity();
    String getProductName();
    double getPrice();
    String getNameImage();
}
