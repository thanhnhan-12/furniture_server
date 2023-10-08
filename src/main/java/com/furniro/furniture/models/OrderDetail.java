package com.furniro.furniture.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderDetail {

    @Id
    @ManyToOne
    @JoinColumn(name = "orderID", nullable = false)
    @JsonIgnore
    private Orders orders;

    @Id
    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    @JsonIgnore
    private Product product;

    private int quantity;

}
