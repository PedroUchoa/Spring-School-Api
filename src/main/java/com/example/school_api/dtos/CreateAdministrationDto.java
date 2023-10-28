package com.example.school_api.dtos;

import com.example.school_api.enums.AdministrationFunctions;

public record CreateAdministrationDto(String name, Double salary, String phone, AdministrationFunctions functional) {
}
