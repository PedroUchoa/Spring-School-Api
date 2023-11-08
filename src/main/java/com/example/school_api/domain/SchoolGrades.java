package com.example.school_api.domain;

import com.example.school_api.dtos.CreateGradeDto;
import com.example.school_api.dtos.UpdateGradeDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "schoolGrades")
@Entity(name = "SchoolGrades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class SchoolGrades {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double firstGrade;
    private Double secondGrade;
    @ManyToOne
    @JoinTable(name = "subject_grades",
            joinColumns = {@JoinColumn(name = "school_grades_id")},
            inverseJoinColumns = {@JoinColumn(name = "school_subject_id")})
    @JsonManagedReference
    private SchoolSubject schoolSubject;

    @ManyToOne
    @JoinTable(name = "report_grades",
            joinColumns = {@JoinColumn(name = "school_grades_id")},
            inverseJoinColumns = {@JoinColumn(name = "school_report_id")})
    @JsonManagedReference
    @JsonIgnore
    private SchoolReport report;

    public SchoolGrades(CreateGradeDto gradesDto, SchoolReport report,SchoolSubject subject) {
        this.firstGrade = gradesDto.firstGrade();
        this.secondGrade = gradesDto.secondGrade();
        this.report = report;
        this.schoolSubject = subject;
    }

    public void updateGrades(UpdateGradeDto gradeDto) {
        if(gradeDto.firstGrade() != null && !gradeDto.firstGrade().toString().isEmpty()){
            this.firstGrade = gradeDto.firstGrade();
        }
        if(gradeDto.secondGrade() != null && !gradeDto.secondGrade().toString().isEmpty()){
            this.secondGrade = gradeDto.secondGrade();
        }
    }
}
