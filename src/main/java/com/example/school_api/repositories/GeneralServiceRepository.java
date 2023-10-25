package com.example.school_api.repositories;

import com.example.school_api.domain.GeneralService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralServiceRepository extends JpaRepository<GeneralService,String> {
}
