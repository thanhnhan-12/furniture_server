package com.furniro.furniture.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wardID;
    private String wardName;

    @ManyToOne
    @JoinColumn(name = "provinceID", nullable = false)
    @JsonIgnore
    private Province province;

    @ManyToOne
    @JoinColumn(name = "districtID", nullable = false)
    @JsonIgnore
    private District district;

}
