package com.example.school_api.repositories;

import com.example.school_api.domain.SchoolReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolReportRepository extends JpaRepository<SchoolReport,String> {
}
