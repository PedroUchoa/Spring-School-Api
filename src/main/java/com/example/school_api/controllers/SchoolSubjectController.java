package com.example.school_api.controllers;

import com.example.school_api.domain.SchoolSubject;
import com.example.school_api.dtos.CreateSubjectDto;
import com.example.school_api.dtos.DetailSubjectDto;
import com.example.school_api.services.SchoolSubjectService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SchoolSubjectController {

    @Autowired
    private SchoolSubjectService subjectService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createSchoolSubject(@RequestBody CreateSubjectDto subjectDto, UriComponentsBuilder componentsBuilder){
        SchoolSubject schoolSubject = subjectService.createSchoolSubject(subjectDto);
        URI uri = componentsBuilder.path("/subject/{id}").buildAndExpand(schoolSubject.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetailSubjectDto>> getAllSubjects(){
        List<DetailSubjectDto> subjectDtos = subjectService.getAllSubjects();
        return ResponseEntity.ok().body(subjectDtos);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DetailSubjectDto> getSubjectByName(@PathVariable String name){
        DetailSubjectDto subjectDtos = subjectService.getSubjectByName(name);
        return ResponseEntity.ok().body(subjectDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailSubjectDto> getSubjectById(@PathVariable String id){
        DetailSubjectDto subjectDtos = subjectService.getSubjectById(id);
        return ResponseEntity.ok().body(subjectDtos);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> updateSubject(@PathVariable String id,@RequestBody CreateSubjectDto subjectDto){
        subjectService.updateSubject(id,subjectDto);
        return ResponseEntity.noContent().build();

    }


}


