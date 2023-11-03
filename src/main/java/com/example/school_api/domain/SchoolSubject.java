package com.example.school_api.domain;

import com.example.school_api.dtos.CreateSubjectDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Professor professor;

    @OneToMany(mappedBy = "schoolSubject", cascade = CascadeType.PERSIST)
    @JsonBackReference
    private List<SchoolGrades> schoolGrades;


    public SchoolSubject(CreateSubjectDto subjectDto) {
        this.name = subjectDto.name();
        this.cargaHoraria = subjectDto.cargaHoraria();
    }

    public void updateSubject(CreateSubjectDto subjectDto) {
        if(subjectDto.cargaHoraria() != null && !subjectDto.cargaHoraria().toString().isEmpty()){
            this.cargaHoraria = subjectDto.cargaHoraria();
        }

    }
}
