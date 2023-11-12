package com.example.school_api.services;

import com.example.school_api.domain.Classroom;
import com.example.school_api.dtos.CreateClassroomDto;
import com.example.school_api.dtos.DetailClassroomDto;
import com.example.school_api.infra.exceptions.ClassroomDuplicatedException;
import com.example.school_api.infra.exceptions.ClassroomNotFoundException;
import com.example.school_api.repositories.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    public Classroom createClassroom(CreateClassroomDto classroomDto) throws ClassroomDuplicatedException {
        if(classroomRepository.getByName(classroomDto.name()) != null){
            throw new ClassroomDuplicatedException(classroomDto.name());
        }
        Classroom classroom = new Classroom(classroomDto);
        return classroomRepository.save(classroom);
    }

    public List<DetailClassroomDto> getAllClassrooms(){
        return classroomRepository.findAll().stream().map(DetailClassroomDto::new).collect(Collectors.toList());
    }

    public DetailClassroomDto getByName(String name) throws ClassroomNotFoundException {
        Classroom classroom = classroomRepository.getByName(name);
        if(classroom == null){
            throw new ClassroomNotFoundException();
        }
        return new DetailClassroomDto(classroom);
    }

    public DetailClassroomDto getById(String id) throws ClassroomNotFoundException {
        Classroom classroom = classroomRepository.findById(id).orElseThrow(()-> new ClassroomNotFoundException());
        return new DetailClassroomDto(classroom);
    }

    public void updateClassroom(String id,CreateClassroomDto classroomDto) throws ClassroomNotFoundException {
        Classroom classroom = classroomRepository.findById(id).orElseThrow(()-> new ClassroomNotFoundException());
        classroom.updateClassroom(classroomDto);
        classroomRepository.save(classroom);
    }

}
