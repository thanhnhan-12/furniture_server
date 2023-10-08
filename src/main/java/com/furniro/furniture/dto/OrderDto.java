package com.furniro.furniture.dto;

import com.furniro.furniture.payload.request.OrderRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Data
public class OrderDto {
//    @NotNull(message = "UserID not empty")
//    private int userID;

    private List<Integer> cartIDs;

    @NotNull(message = "AddressID not empty")
    private int addressID;

    @Size.List({@Size(min = 1, message = "orderItems not empty")})
    private List<OrderRequestDto> orderItems;
}
