package com.example.school_api.repositories;

import com.example.school_api.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,String> {
}
