package com.example.school_api.repositories;

import com.example.school_api.domain.Administration;
import com.example.school_api.dtos.DetailAdministrationDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;


public interface AdministrationRepository extends JpaRepository<Administration,String> {
    List<Administration> findAllByIsActiveTrue();

    List<Administration> findAllByFunctionalAndIsActiveTrue(String function);

    Administration getByName(String name);

    Administration findByNameAndIsActiveTrue(String name);
}
