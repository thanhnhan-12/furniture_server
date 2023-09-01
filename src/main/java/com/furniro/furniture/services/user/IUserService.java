package com.furniro.furniture.services.user;

import com.furniro.furniture.payload.response.ListResponse;

public interface IUserService<T> {

    T findByEmail(String email);

    boolean isUsernameTaken(String username);

    boolean isEmailTaken(String email);

    T createUser(T user);
}
