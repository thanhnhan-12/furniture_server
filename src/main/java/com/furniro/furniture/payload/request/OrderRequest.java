package com.furniro.furniture.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    @NotNull(message = "userID is not empty")
    private int userID;

    @NotBlank(message = "firstName is a required field.")
    private String firstName;

    @NotBlank(message = "lastName is a required field.")
    private String lastName;

    @NotNull(message = "wardID is not empty")
    private int wardID;

    @NotBlank(message = "Address Name is not empty")
    private String addressName;

    @NotBlank(message = "email is a required field.")
    @Email(message = "Incorrect email format")
    private String email;

    @NotBlank(message = "phoneNumber is required field.")
    private String phoneNumber;

}
