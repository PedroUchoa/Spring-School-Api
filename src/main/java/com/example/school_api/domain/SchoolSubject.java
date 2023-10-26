package com.example.school_api.domain;

import com.example.school_api.dtos.CreateSubjectDto;
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


    public SchoolSubject(CreateSubjectDto subjectDto) {
        this.name = subjectDto.name();
        this.cargaHoraria = subjectDto.cargaHoraria();
    }

    public void updateSubject(CreateSubjectDto subjectDto) {
        if(subjectDto.name() != null && !subjectDto.name().isEmpty()){
            this.name = subjectDto.name();
        }
        if(subjectDto.cargaHoraria() != null && !subjectDto.cargaHoraria().toString().isEmpty()){
            this.cargaHoraria = subjectDto.cargaHoraria();
        }

    }
}
