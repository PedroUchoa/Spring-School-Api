package com.example.school_api.services;

import com.example.school_api.domain.Student;
import com.example.school_api.dtos.CreateStudentDto;
import com.example.school_api.dtos.DetailStudentDto;
import com.example.school_api.infra.exceptions.DuplicatedStudentException;
import com.example.school_api.infra.exceptions.IsAlreadyDesactivedException;
import com.example.school_api.infra.exceptions.StudentNotFoundException;
import com.example.school_api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Student createUser(CreateStudentDto studentDto) throws DuplicatedStudentException {
        Student student = new Student(studentDto);
        if(studentRepository.findByName(studentDto.name()) != null){
            throw new DuplicatedStudentException(studentDto.name());
        }
        return studentRepository.save(student);
    }

    public List<DetailStudentDto>  getAllStudents(){
        return studentRepository.findAll().stream().map(DetailStudentDto::new).collect(Collectors.toList());
    }

    public List<DetailStudentDto> getAllStudentsActives(){
        return studentRepository.findStudentByIsActiveTrue().stream().map(DetailStudentDto::new).collect(Collectors.toList());
    }

    public DetailStudentDto getStudentByName(String name) throws StudentNotFoundException {
        Student student = studentRepository.findByName(name);
        if(student == null){
            throw new StudentNotFoundException();
        }
        return new DetailStudentDto(student);
    }

    public DetailStudentDto getStudentById(String id) throws StudentNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException());
        return new DetailStudentDto(student);
    }

    public void updateStudent(String id, CreateStudentDto studentDto) throws StudentNotFoundException {
        Student student = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException());
        student.updateStudent(studentDto);
        studentRepository.save(student);
    }

    public void disableStudent(String id) throws StudentNotFoundException, IsAlreadyDesactivedException {
        Student student = studentRepository.findById(id).orElseThrow(()->new StudentNotFoundException());
        if (!student.isActive()){
            throw new IsAlreadyDesactivedException(student.getName());
        }
        student.setActive(false);
        student.getSchoolReport().forEach(x->x.desactiveReport());
        studentRepository.save(student);
    }

}
