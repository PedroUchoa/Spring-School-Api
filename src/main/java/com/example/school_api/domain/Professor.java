package com.example.school_api.domain;

import com.example.school_api.dtos.CreateProfessorDto;
import com.example.school_api.dtos.UpdateProfessorDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "professor")
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
    @JsonManagedReference
    @JsonIgnore
    private SchoolSubject schoolSubject;


    public Professor(CreateProfessorDto professorDto, SchoolSubject schoolSubject) {
        super(professorDto.name(), professorDto.phone(), professorDto.salary());
        this.schoolSubject = schoolSubject;
    }


    public void updateProfessor(UpdateProfessorDto professorDto) {
        if(professorDto.name() != null && !professorDto.name().isEmpty()){
            this.setName(professorDto.name());
        }
        if(professorDto.phone() != null && !professorDto.phone().isEmpty()){
            this.setPhone(professorDto.phone());
        }
        if(professorDto.salary() != null && !professorDto.salary().toString().isEmpty()){
            this.setSalary(professorDto.salary());
        }
    }
}
