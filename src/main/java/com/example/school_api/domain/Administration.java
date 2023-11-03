package com.example.school_api.domain;

import com.example.school_api.dtos.CreateAdministrationDto;
import com.example.school_api.enums.AdministrationFunctions;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
    @Enumerated(EnumType.STRING)
    private AdministrationFunctions functional;


    public Administration(CreateAdministrationDto administrationDto) {
        super(administrationDto.name(), administrationDto.phone(), administrationDto.salary());
        this.functional = administrationDto.functional();
    }

    public void updateAdministration(CreateAdministrationDto administrationDto) {
        if(administrationDto.name() != null && !administrationDto.name().isEmpty()){
            this.setName(administrationDto.name());
        }
        if(administrationDto.phone() != null && !administrationDto.phone().isEmpty()){
            this.setPhone(administrationDto.phone());
        }
        if(administrationDto.salary() != null && !administrationDto.salary().toString().isEmpty()){
            this.setSalary(administrationDto.salary());
        }
        if(administrationDto.functional() != null && !administrationDto.functional().getAdministrationFunctions().isEmpty()){
            this.setFunctional(administrationDto.functional());
        }
    }
}
