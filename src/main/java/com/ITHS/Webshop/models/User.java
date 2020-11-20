package com.ITHS.Webshop.models;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active", columnDefinition = "BOOLEAN")
    private Boolean active = true;

    @Column(name = "role")
    private int role;

}
