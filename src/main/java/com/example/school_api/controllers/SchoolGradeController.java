package com.example.school_api.controllers;

import com.example.school_api.domain.SchoolGrades;
import com.example.school_api.dtos.CreateGradeDto;
import com.example.school_api.dtos.UpdateGradeDto;
import com.example.school_api.services.SchoolGradesService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/grade")
public class SchoolGradeController {

    @Autowired
    private SchoolGradesService schoolGradesService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createGrades(@RequestBody CreateGradeDto gradeDto, UriComponentsBuilder componentsBuilder){
        SchoolGrades grades = schoolGradesService.createGrades(gradeDto);
        URI uri = componentsBuilder.path("/grades/{id}").buildAndExpand(grades.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> updateGrades(@RequestBody UpdateGradeDto gradeDto, @PathVariable String id){
        schoolGradesService.updateGrades(gradeDto,id);
        return ResponseEntity.noContent().build();
    }


}
