package com.furniro.furniture.controllers;

import com.furniro.furniture.config.JwtConfig;
import com.furniro.furniture.constants.MessageEnum;
import com.furniro.furniture.exception.ResourceNotFoundException;
import com.furniro.furniture.models.Role;
import com.furniro.furniture.models.User;
import com.furniro.furniture.payload.request.LoginRequest;
import com.furniro.furniture.payload.request.RegisterRequest;
import com.furniro.furniture.payload.response.CommonResponse;
import com.furniro.furniture.payload.response.JwtResponse;
import com.furniro.furniture.payload.response.MessageResponse;
import com.furniro.furniture.repositories.RoleRepository;
import com.furniro.furniture.services.token.RefreshTokenService;
import com.furniro.furniture.services.user.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.AlreadyBoundException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor

public class AuthController {

    private UserService<User> userService;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtConfig jwtConfig;
    private RefreshTokenService refreshTokenService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest)
            throws AlreadyBoundException {

        // add check for email exists in DB
        if (userService.isEmailTaken(registerRequest.getEmail())) {
            throw new AlreadyBoundException(MessageEnum.ALREADY_EXIST.getFormattedField("Email"));
        }

//        if (userService.isUsernameTaken(registerRequest.getUsername())) {
//            throw new AlreadyBoundException(MessageEnum.ALREADY_EXIST.getFormattedField("Username"));
//        }

        User user = new User();
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
//        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));


        Role roles = roleRepository.findByName(
                com.furniro.furniture.constants.Role.ROLE_USER);

        // Set 1 role
        user.setRoles(roles);
        User userResult = userService.createUser(user);
        CommonResponse<User> userCommonResponse =
                new CommonResponse<>("User registered successfully", userResult);

        return ResponseEntity.status(HttpStatus.CREATED).body(userCommonResponse);
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginRequest loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail());

        if (user == null) {
            throw new ResourceNotFoundException("User not found with email");
        }

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean isMatch = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());

        if (isMatch) {
            try {
                Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                                loginRequest.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);

                List<String> roleList = authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());
                System.out.println("ROLE" + roleList);
                final String token = jwtConfig.generateToken(loginRequest.getEmail(), roleList);

                boolean isExitsUserToken = refreshTokenService.existsByUserId(user.getUserID());

                if (isExitsUserToken) {
                    refreshTokenService.deleteByUserId(user.getUserID());
                }

                com.furniro.furniture.models.RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getUserID());

                return ResponseEntity.ok(
                        new JwtResponse(token, refreshToken.getToken(), user.getUsername(),
                                user.getEmail(), roleList));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new MessageResponse(e.getMessage()));
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MessageResponse("Password does not match stored value"));
    }

}
