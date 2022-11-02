package com.example.petClinic.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owner")
public class Owner extends Person{

    @Column(name = "address")
    @NotNull
    private String address;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "telephone")
    private String telephone;


}
