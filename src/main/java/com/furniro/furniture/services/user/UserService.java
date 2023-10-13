package com.furniro.furniture.services.user;

import com.furniro.furniture.dto.UserDto;

import java.util.List;

public interface UserService<T> {

//    List<UserDto> getAllUser();

    T findByEmail(String email);

//    long countUser();

    boolean isUsernameTaken(String username);

    boolean isEmailTaken(String email);

    T createUser(T user);

    T getUserLogin();

}
