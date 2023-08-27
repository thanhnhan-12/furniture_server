package com.furniro.furniture.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentID;
    private String comment;
    private LocalDateTime createdAt;
    private int star;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "productID", nullable = false)
    @JsonIgnore
    private Product product;

}
