package com.example.school_api.dtos;

import com.example.school_api.domain.SchoolGrades;
import com.example.school_api.domain.SchoolReport;
import com.example.school_api.domain.Student;

import java.time.LocalDateTime;
import java.util.Set;

public record DetailReportDto(String id, String semester, Boolean isActive, LocalDateTime startDate, LocalDateTime endDate, Set<SchoolGrades> grades , Student student) {

    public DetailReportDto(SchoolReport report){
        this(report.getId(),report.getSemester(),report.getIsActive(),report.getStartDate(),report.getEndDate(),report.getSchoolGrades(),report.getStudent());
    }
}
