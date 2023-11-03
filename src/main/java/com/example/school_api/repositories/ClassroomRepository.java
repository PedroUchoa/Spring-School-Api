package com.example.school_api.repositories;

import com.example.school_api.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;

public interface ClassroomRepository extends JpaRepository<Classroom,String> {
    Classroom getByName(String name);

}
