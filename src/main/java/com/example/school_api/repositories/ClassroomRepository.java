package com.example.school_api.repositories;

import com.example.school_api.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom,String> {
}
