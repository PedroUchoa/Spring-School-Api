package com.example.school_api.dtos;

import com.example.school_api.domain.SchoolReport;
import com.example.school_api.domain.Student;

import java.time.LocalDateTime;
import java.util.List;

public record DetailStudentDto(String id, String name, Boolean isActive, String phone, LocalDateTime startDate, LocalDateTime endDate, List<SchoolReport> schoolReports) {

    public DetailStudentDto(Student student){
        this(student.getId(), student.getName(), student.isActive(), student.getPhone(), student.getStartDate(),student.getEndDate(),student.getSchoolReport());
    }

}
