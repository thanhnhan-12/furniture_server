package com.furniro.furniture.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class OrderRequestDto {

    private Long productID;
    private int quantity;
}
