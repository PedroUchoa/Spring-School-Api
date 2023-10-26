package com.example.school_api.repositories;

import com.example.school_api.domain.Student;
import com.example.school_api.dtos.DetailStudentDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findStudentByIsActiveTrue();

    Student findByName(String name);
}
