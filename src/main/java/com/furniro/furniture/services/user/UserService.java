package com.furniro.furniture.services.user;

public interface UserService<T> {

    T findByEmail(String email);

    boolean isUsernameTaken(String username);

    boolean isEmailTaken(String email);

    T createUser(T user);

    T getUserLogin();

}
