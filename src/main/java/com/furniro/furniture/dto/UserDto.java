package com.furniro.furniture.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @Id
    private int userID;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private boolean isLocked;

}
