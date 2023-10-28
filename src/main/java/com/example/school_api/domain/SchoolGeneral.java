package com.example.school_api.domain;

import com.example.school_api.dtos.CreateGeneralServiceDto;
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
    @OneToOne
    @JoinTable(name = "service_classroom",
            joinColumns = {@JoinColumn(name = "general_services_id")},
            inverseJoinColumns = {@JoinColumn(name = "classrooms_id")})
    private Classroom classroom;

    public SchoolGeneral(CreateGeneralServiceDto generalDto, Classroom classroom) {
        super(generalDto.name(),generalDto.phone(), generalDto.salary());
        this.classroom = classroom;
    }

    public void updateGeneral(CreateGeneralServiceDto generalDto, Classroom classroom) {
        if(generalDto.name() != null && !generalDto.name().isEmpty()){
            this.setName(generalDto.name());
        }
        if(generalDto.phone() != null && !generalDto.phone().isEmpty()){
            this.setPhone(generalDto.phone());
        }
        if(generalDto.salary() != null && !generalDto.salary().toString().isEmpty()){
            this.setSalary(generalDto.salary());
        }
        if(classroom != null){
            this.classroom = classroom;
        }
    }
}
