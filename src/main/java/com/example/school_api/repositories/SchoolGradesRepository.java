package com.example.school_api.repositories;

import com.example.school_api.domain.SchoolGrades;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolGradesRepository extends JpaRepository<SchoolGrades,String> {
}
