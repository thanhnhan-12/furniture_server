package com.furniro.furniture.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequest {

    @NotBlank(message = "Address Name is not empty")
    private String addressName;

    @NotNull(message = "UserID is not empty")
    private int userID;

    @NotNull(message = "WardID is not empty")
    private int wardID;

}
