package com.furniro.furniture.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sizeID;
    private String value;
}
