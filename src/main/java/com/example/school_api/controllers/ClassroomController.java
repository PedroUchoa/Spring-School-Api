package com.example.school_api.controllers;

import com.example.school_api.domain.Classroom;
import com.example.school_api.dtos.CreateClassroomDto;
import com.example.school_api.dtos.DetailClassroomDto;
import com.example.school_api.services.ClassroomService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createClassroom(@RequestBody CreateClassroomDto classroomDto, UriComponentsBuilder componentsBuilder)throws Exception {
        Classroom classroom = classroomService.createClassroom(classroomDto);
        URI uri = componentsBuilder.path("/classroom/{id}").buildAndExpand(classroom.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetailClassroomDto>> getAllClassrooms(){
        List<DetailClassroomDto> classroomDtos = classroomService.getAllClassrooms();
        return ResponseEntity.ok().body(classroomDtos);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<DetailClassroomDto> getByName(@PathVariable String name)throws Exception{
        DetailClassroomDto classroomDto = classroomService.getByName(name);
        return ResponseEntity.ok().body(classroomDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailClassroomDto> getById(@PathVariable String id)throws Exception{
        DetailClassroomDto classroomDto = classroomService.getById(id);
        return ResponseEntity.ok().body(classroomDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateClassroom(@PathVariable String id, @RequestBody CreateClassroomDto classroomDto)throws Exception{
        classroomService.updateClassroom(id, classroomDto);
        return ResponseEntity.noContent().build();
    }


}
