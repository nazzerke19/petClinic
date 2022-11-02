package com.example.petClinic.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@Entity
@Table(name = "person")
public class Person {

    @Id
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "email")
    private String email;



}
