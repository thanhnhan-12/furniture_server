package com.furniro.furniture.controllers;

import com.furniro.furniture.constants.MessageEnum;
import com.furniro.furniture.models.Role;
import com.furniro.furniture.models.User;
import com.furniro.furniture.payload.request.RegisterRequest;
import com.furniro.furniture.payload.response.CommonResponse;
import com.furniro.furniture.repositories.RoleRepository;
import com.furniro.furniture.services.user.IUserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.AlreadyBoundException;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor

public class AuthController {

    private IUserService<User> userService;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
//    private AuthenticationManager authenticationManager;
//    private JwtConfig jwtConfig;
//    private IRefreshToken refreshTokenService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest)
            throws AlreadyBoundException {

        // add check for email exists in DB
        if (userService.isEmailTaken(registerRequest.getEmail())) {
            throw new AlreadyBoundException(MessageEnum.ALREADY_EXIST.getFormattedField("Email"));
        }

        if (userService.isUsernameTaken(registerRequest.getUsername())) {
            throw new AlreadyBoundException(MessageEnum.ALREADY_EXIST.getFormattedField("Username"));
        }

        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

        Role roles = roleRepository.findByName(
                com.furniro.furniture.constants.Role.ROLE_USER);

        // Set 1 role
        user.setRoles(Collections.singleton(roles));
        User userResult = userService.createUser(user);
        CommonResponse<User> userCommonResponse =
                new CommonResponse<>("User registered successfully", userResult);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCommonResponse);
    }

}
