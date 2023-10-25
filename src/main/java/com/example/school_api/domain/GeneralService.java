package com.example.school_api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "generalServices")
@Entity(name = "GeneralService")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GeneralService extends Employee{
    @OneToOne
    @JoinTable(name = "service_classroom",
            joinColumns = {@JoinColumn(name = "general_services_id")},
            inverseJoinColumns = {@JoinColumn(name = "classrooms_id")})
    private Classroom classroom;

}
