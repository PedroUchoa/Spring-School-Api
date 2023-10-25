package com.example.school_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "administrations")
@Entity(name = "Administration")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Administration extends Employee{
    private String functional;


}
