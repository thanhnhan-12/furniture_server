package com.furniro.furniture.payload.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadImageRequest {
    @NotNull(message = "ProductID is not empty")
    private int productID;
}
