package com.example.school_api.services;

import com.example.school_api.domain.Classroom;
import com.example.school_api.dtos.CreateClassroomDto;
import com.example.school_api.dtos.DetailClassroomDto;
import com.example.school_api.dtos.DetailGeneralServiceDto;
import com.example.school_api.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public Classroom createClassroom(CreateClassroomDto classroomDto){
        Classroom classroom = new Classroom(classroomDto);
        return classroomRepository.save(classroom);
    }

    public List<DetailClassroomDto> getAllClassrooms(){
        return classroomRepository.findAll().stream().map(DetailClassroomDto::new).collect(Collectors.toList());
    }

    public DetailClassroomDto getByName(String name){
        Classroom classroom = classroomRepository.findByName();
        return new DetailClassroomDto(classroom);
    }

    public DetailClassroomDto getById(String id){
        Classroom classroom = classroomRepository.getReferenceById(id);
        return new DetailClassroomDto(classroom);
    }

    public void updateClassroom(String id,CreateClassroomDto classroomDto){
        Classroom classroom = classroomRepository.getReferenceById(id);
        classroom.updateClassroom(classroomDto);
    }

}
