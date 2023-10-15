package com.furniro.furniture.controllers;

import com.furniro.furniture.dto.UserDto;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.User;
import com.furniro.furniture.services.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user")

public class UserController {

    private UserService<User> userService;
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> userDtoList = userService.getAllUser();
        if(userDtoList.isEmpty()) {
            throw new ResourceNotFoundException("User List not found");
        } else {
            return ResponseEntity.ok(userDtoList);
        }
    }

}
