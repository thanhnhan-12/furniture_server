package com.furniro.furniture.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int imageID;
    private String nameImage;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    @JsonIgnore
    private Product product;

}
