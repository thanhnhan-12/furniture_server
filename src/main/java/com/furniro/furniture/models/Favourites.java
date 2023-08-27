package com.furniro.furniture.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Favourites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int favouriteID;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    @JsonIgnore
    private User user;

}
