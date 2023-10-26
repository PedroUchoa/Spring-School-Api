package com.example.school_api.services;

import com.example.school_api.domain.SchoolSubject;
import com.example.school_api.dtos.CreateSubjectDto;
import com.example.school_api.dtos.DetailSubjectDto;
import com.example.school_api.repositories.SchoolSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolSubjectService {

    @Autowired
    private SchoolSubjectRepository schoolSubjectRepository;

    public void createSchoolSubject(CreateSubjectDto subjectDto){
        schoolSubjectRepository.save(new SchoolSubject(subjectDto));
    }

    public List<DetailSubjectDto> getAllSubjects(){
        return schoolSubjectRepository.findAll().stream().map(DetailSubjectDto::new).collect(Collectors.toList());
    }

    public DetailSubjectDto getSubjectByName(String name){
        SchoolSubject subject = schoolSubjectRepository.getByName(name);
        return new DetailSubjectDto(subject);
    }

    public DetailSubjectDto getSubjectById(String id){
        SchoolSubject subject = schoolSubjectRepository.getReferenceById(id);
        return new DetailSubjectDto(subject);
    }


    public void updateSubject(String id, CreateSubjectDto subjectDto){
        SchoolSubject subject = schoolSubjectRepository.getReferenceById(id);
        subject.updateSubject(subjectDto);
        schoolSubjectRepository.save(subject);
    }


}
