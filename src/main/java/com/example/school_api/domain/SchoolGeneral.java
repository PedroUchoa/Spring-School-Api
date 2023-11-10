package com.example.school_api.domain;

import com.example.school_api.dtos.CreateGeneralServiceDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class SchoolGeneral extends Employee{
    @ManyToOne
    @JoinTable(name = "service_classroom",
            joinColumns = {@JoinColumn(name = "general_services_id")},
            inverseJoinColumns = {@JoinColumn(name = "classrooms_id")})
    @JsonManagedReference
    private Classroom classroom;

    public SchoolGeneral(CreateGeneralServiceDto generalDto, Classroom classroom) {
        super(generalDto.name(),generalDto.phone(), generalDto.salary());
        this.classroom = classroom;
    }

    public void updateGeneral(CreateGeneralServiceDto generalDto) {
        if(generalDto.name() != null && !generalDto.name().isEmpty()){
            this.setName(generalDto.name());
        }
        if(generalDto.phone() != null && !generalDto.phone().isEmpty()){
            this.setPhone(generalDto.phone());
        }
        if(generalDto.salary() != null && !generalDto.salary().toString().isEmpty()){
            this.setSalary(generalDto.salary());
        }
    }
}
