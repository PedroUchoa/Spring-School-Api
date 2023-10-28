package com.example.school_api.dtos;

import com.example.school_api.domain.Administration;
import com.example.school_api.enums.AdministrationFunctions;

import java.time.LocalDateTime;

public record DetailAdministrationDto(String id, String name, Double Salary,
                                      String phone, LocalDateTime startDate,
                                      LocalDateTime endDate, Boolean isActive, AdministrationFunctions functional) {

    public DetailAdministrationDto(Administration administration){
        this(administration.getId(), administration.getName(), administration.getSalary(), administration.getPhone(), administration.getStartDate(),administration.getEndDate(),administration.getIsActive(),administration.getFunctional());
    }

}
