package com.furniro.furniture.dto;

public interface UserDto {

    int getUserID();
    String getUsername();
    String getEmail();
    String getPassword();
    String getFirstName();
    String getLastName();
    boolean isLocked();

}
