package com.furniro.furniture.dto;

public interface AddressDto {
    int getAddressID();
    int getProvinceID();
    String getProvinceName();
    int getDistrictID();
    String getDistrictName();
    int getWardID();
    String getWardName();
    String getAddressName();
}
