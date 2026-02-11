package com.authdemo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MyUser {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @Column(unique=true)
    private String pname;
    private String role;
    private String password;
}
