package com.example.school_api.dtos;

import com.example.school_api.domain.SchoolGrades;
import com.example.school_api.domain.SchoolReport;
import com.example.school_api.domain.SchoolSubject;

public record DetailGradesDto(String id, Double firstGrade, Double secondGrade, SchoolSubject schoolSubject, SchoolReport schoolReport) {

    public DetailGradesDto(SchoolGrades grades){
        this(grades.getId(), grades.getFirstGrade(), grades.getSecondGrade(), grades.getSchoolSubject(),grades.getReport());
    }

}
