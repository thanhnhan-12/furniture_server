package com.furniro.furniture.payload.request;

import com.furniro.furniture.validator.NoWhitespace;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class UpdateInfoRequest {
    @NotBlank(message = "firstName is a required field.")
    private String firstName;

    @NotBlank(message = "lastName is a required field.")
    private String lastName;

    @NotBlank(message = "userName is a required field.")
    @NoWhitespace(message = "Username must not contain whitespace")
    private String username;

    private LocalDateTime createdTime;
    private String email;
}
