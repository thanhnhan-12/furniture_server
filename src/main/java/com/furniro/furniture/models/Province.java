package com.furniro.furniture.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int provinceID;
    private String provinceName;

    @OneToMany(mappedBy = "province", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<District> districtList;

}
