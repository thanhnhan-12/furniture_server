package com.furniro.furniture.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
import java.util.Set;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"username", "password", "email", "phoneNumber"})}, name="user" )
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID;
    private String username;
    private String password;
    private String phoneNumber;
    private String firstName;
    private String lastName;
//    private String role;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "name", joinColumns = @JoinColumn(name = "userID",
            referencedColumnName = "userID"), inverseJoinColumns = @JoinColumn(name = "roleID",
            referencedColumnName = "roleID")
    )
    private Set<Role> roles;

    @Email
    private String email;

    private boolean isLocked;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> ordersList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Cart> cartList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Favourites> favouritesList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addressList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> commentList;
}
