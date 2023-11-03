package com.example.school_api.repositories;

import com.example.school_api.domain.SchoolGrades;
import com.example.school_api.dtos.DetailGradesDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchoolGradesRepository extends JpaRepository<SchoolGrades,String> {
    List<SchoolGrades> findAllByReportStudentNameAndReportSemester(String studentName, String schoolReportSemester);
}
