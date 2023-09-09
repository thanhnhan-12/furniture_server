package com.furniro.furniture.services.user;

public interface UserServiceImp<T> {

    T findByEmail(String email);

    boolean isUsernameTaken(String username);

    boolean isEmailTaken(String email);

    T createUser(T user);
}
