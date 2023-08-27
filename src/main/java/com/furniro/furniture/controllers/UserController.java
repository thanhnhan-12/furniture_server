package com.furniro.furniture.controllers;

import com.furniro.furniture.models.User;
import com.furniro.furniture.services.user.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/")

public class UserController {

    private IUserService<User> userService;
//    private UserMapper userMapper;
    private PasswordEncoder passwordEncoder;

}
