package com.example.school_api.repositories;

import com.example.school_api.domain.SchoolGeneral;
import com.example.school_api.dtos.DetailGeneralServiceDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneralServiceRepository extends JpaRepository<SchoolGeneral,String> {
    List<SchoolGeneral> findAllByIsActiveTrue();

    SchoolGeneral getByName(String name);

    SchoolGeneral getByNameAndIsActiveTrue(String name);
}
