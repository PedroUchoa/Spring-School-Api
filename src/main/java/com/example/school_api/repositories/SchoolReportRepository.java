package com.example.school_api.repositories;

import com.example.school_api.domain.SchoolReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface SchoolReportRepository extends JpaRepository<SchoolReport,String> {
   List<SchoolReport> findAllReportByStudentName(String name);

   List<SchoolReport>  findAllReportByisActiveTrueAndStudentName(String name);
}
