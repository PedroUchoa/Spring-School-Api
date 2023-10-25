package com.example.school_api.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "professors")
@Entity(name = "Professor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professor extends Employee{

    @OneToOne
    @JoinTable(name = "professor_subject",
            joinColumns = {@JoinColumn(name = "professor_id")},
            inverseJoinColumns = {@JoinColumn(name = "school_subject_id")})
    private SchoolSubject schoolSubject;


}
