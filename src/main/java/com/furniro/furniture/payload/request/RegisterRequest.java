package com.furniro.furniture.payload.request;

import com.furniro.furniture.validator.NoWhitespace;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter

public class RegisterRequest {

    @NotBlank(message = "username is a required field.")
    @NoWhitespace(message = "Username must not contain whitespace")
    private String username;

    @NotBlank(message = "Password is a required field.")
    @Length(min = 8, message = "Password need at least 8 characters")
    private String password;

    @NotBlank(message = "firstName is a required field.")
    private String firstName;

    @NotBlank(message = "lastName is a required field.")
    private String lastName;

    @NotBlank(message = "email is a required field.")
    @Email(message = "Incorrect email format")
    private String email;

}
