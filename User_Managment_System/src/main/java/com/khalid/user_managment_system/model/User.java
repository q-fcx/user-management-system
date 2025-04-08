package com.khalid.user_managment_system.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 4, message = "name must be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotNull
    @Size(min = 4, message = "username must be more than 4 characters")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;

    @NotNull
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotNull
    @Email
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;

    @NotNull
    @Column(columnDefinition = "varchar(20) not null")
    private String role;

    @NotNull
    @Positive
    @Column(columnDefinition = "int not null")
    private Integer age;



}
