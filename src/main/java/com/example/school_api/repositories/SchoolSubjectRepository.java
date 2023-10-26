package com.example.school_api.repositories;

import com.example.school_api.domain.SchoolSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolSubjectRepository extends JpaRepository<SchoolSubject, String> {
    SchoolSubject getByName(String name);
}
