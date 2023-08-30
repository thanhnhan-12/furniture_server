package com.furniro.furniture.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String refresh_token;
    private String username;
    private String email;
    private List<String> roles;
}
