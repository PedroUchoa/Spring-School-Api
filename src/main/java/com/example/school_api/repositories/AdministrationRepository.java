package com.example.school_api.repositories;

import com.example.school_api.domain.Administration;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdministrationRepository extends JpaRepository<Administration,String> {
}
