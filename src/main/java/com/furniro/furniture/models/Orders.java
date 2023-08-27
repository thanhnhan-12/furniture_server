package com.furniro.furniture.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;
    private double totalPrice;
    private LocalDateTime createdAt;
    private boolean status;
    private LocalDateTime acceptDate;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "addressID", nullable = false)
    @JsonIgnore
    private Address address;

}
