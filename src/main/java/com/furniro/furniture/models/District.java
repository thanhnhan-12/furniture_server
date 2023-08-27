package com.furniro.furniture.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter

public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int districtID;
    private String districtName;

    @ManyToOne
    @JoinColumn(name = "provinceID", nullable = false)
    @JsonIgnore
    private Province province;

    @OneToMany(mappedBy = "district", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ward> wardList;

}
