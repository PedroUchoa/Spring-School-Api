package com.example.school_api.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "schoolSubject")
@Entity(name = "SchoolSubject")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class SchoolSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Double cargaHoraria;
    @OneToOne(mappedBy = "schoolSubject")
    private Professor professor;
    @OneToMany(mappedBy = "schoolSubject", cascade = CascadeType.PERSIST)
    private List<SchoolGrades> schoolGrades;




}
