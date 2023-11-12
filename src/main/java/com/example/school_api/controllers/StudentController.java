package com.example.school_api.controllers;

import com.example.school_api.domain.Student;
import com.example.school_api.dtos.CreateStudentDto;
import com.example.school_api.dtos.DetailStudentDto;
import com.example.school_api.services.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createUser(@RequestBody CreateStudentDto studentDto, UriComponentsBuilder componentsBuilder)throws Exception{
        Student student = studentService.createUser(studentDto);
        URI uri = componentsBuilder.path("/student/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetailStudentDto>> getAllStudents(){
        List<DetailStudentDto> detailStudentDtos = studentService.getAllStudents();
        return ResponseEntity.ok().body(detailStudentDtos);
    }

    @GetMapping("/actives")
    public ResponseEntity<List<DetailStudentDto>> getAllStudentsActives(){
        List<DetailStudentDto> detailStudentDtos = studentService.getAllStudentsActives();
        return ResponseEntity.ok().body(detailStudentDtos);
    }

    @GetMapping
    public ResponseEntity<DetailStudentDto> getStudentByName(@RequestParam String name) throws Exception {
        DetailStudentDto studentDto = studentService.getStudentByName(name);
        return ResponseEntity.ok().body(studentDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailStudentDto> getStudentById(@PathVariable String id) throws Exception{
        DetailStudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok().body(studentDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> updateStudent(@RequestBody CreateStudentDto studentDto, @PathVariable String id)throws Exception{
        studentService.updateStudent(id,studentDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> disableStudent(@PathVariable String id) throws Exception{
        studentService.disableStudent(id);
        return ResponseEntity.noContent().build();
    }

}
