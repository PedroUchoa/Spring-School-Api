package com.example.school_api.dtos;

import com.example.school_api.domain.Classroom;
import com.example.school_api.domain.Professor;

public record DetailClassroomDto(String id, String name, String localization) {
    public DetailClassroomDto(Classroom classroom) {
        this(classroom.getId(), classroom.getName(), classroom.getLocalization());
    }
}
