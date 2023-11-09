package com.example.school_api.repositories;

import com.example.school_api.domain.Professor;
import com.example.school_api.dtos.DetailProfessorDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor,String> {
    List<Professor> findAllByIsActiveTrue();

    Professor getByName(String name);

    Professor findBySchoolSubjectNameAndIsActiveTrue(String subjectName);

    Professor getByNameAndIsActiveTrue(String name);
}
