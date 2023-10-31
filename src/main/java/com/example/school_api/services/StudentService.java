package com.example.school_api.services;

import com.example.school_api.domain.Student;
import com.example.school_api.dtos.CreateStudentDto;
import com.example.school_api.dtos.DetailStudentDto;
import com.example.school_api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student createUser(CreateStudentDto studentDto){
      return studentRepository.save(new Student(studentDto));
    }

    public List<DetailStudentDto>  getAllStudents(){
        return studentRepository.findAll().stream().map(DetailStudentDto::new).collect(Collectors.toList());
    }

    public List<DetailStudentDto> getAllStudentsActives(){
        return studentRepository.findStudentByIsActiveTrue().stream().map(DetailStudentDto::new).collect(Collectors.toList());
    }

    public DetailStudentDto getStudentByName(String name){
        Student student = studentRepository.findByName(name);
        return new DetailStudentDto(student);
    }

    public DetailStudentDto getStudentById(String id){
        Student student = studentRepository.getReferenceById(id);
        return new DetailStudentDto(student);
    }

    public void updateStudent(String id, CreateStudentDto studentDto){
        Student student = studentRepository.getReferenceById(id);
        student.updateStudent(studentDto);
        studentRepository.save(student);
    }

    public void disableStudent(String id){
        Student student = studentRepository.getReferenceById(id);
        if(student ==null && !student.isActive()){
            throw new IllegalArgumentException("invalido");
        }
        student.setActive(false);
        studentRepository.save(student);
    }

}
