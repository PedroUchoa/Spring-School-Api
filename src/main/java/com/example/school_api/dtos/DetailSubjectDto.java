package com.example.school_api.dtos;

import com.example.school_api.domain.Professor;
import com.example.school_api.domain.SchoolSubject;

public record DetailSubjectDto(String id, String name, Double cargaHoraria, Professor professor) {

    public DetailSubjectDto(SchoolSubject subject){
        this(subject.getId(),subject.getName(),subject.getCargaHoraria(),subject.getProfessor());
    }
}
