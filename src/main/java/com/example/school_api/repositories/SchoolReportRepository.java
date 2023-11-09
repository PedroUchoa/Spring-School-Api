package com.example.school_api.repositories;

import com.example.school_api.domain.SchoolReport;
import com.example.school_api.dtos.DetailReportDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface SchoolReportRepository extends JpaRepository<SchoolReport,String> {
   List<SchoolReport> findAllReportByStudentName(String name);

   List<SchoolReport>  findAllReportByisActiveTrueAndStudentName(String name);

    List<SchoolReport> findAllBySemester(String semester);

    SchoolReport findBySemesterAndStudentName( String semester,String studentName);

    SchoolReport findReportBySemesterAndStudentNameAndSchoolGradesSchoolSubjectName(String reportSemester, String studentName, String subjectName);
}
