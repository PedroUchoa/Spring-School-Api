package com.example.school_api.services;

import com.example.school_api.domain.Professor;
import com.example.school_api.domain.SchoolSubject;
import com.example.school_api.dtos.CreateProfessorDto;
import com.example.school_api.dtos.DetailProfessorDto;
import com.example.school_api.dtos.UpdateProfessorDto;
import com.example.school_api.repositories.ProfessorRepository;
import com.example.school_api.repositories.SchoolSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private SchoolSubjectRepository schoolSubjectRepository;

    public Professor createProfessor(CreateProfessorDto professorDto){
        SchoolSubject schoolSubject = schoolSubjectRepository.getByName(professorDto.subjectName());
        Professor professor = new Professor(professorDto, schoolSubject);
        return professorRepository.save(professor);
    }

    public List<DetailProfessorDto> getAllProfessors(){
        return  professorRepository.findAll().stream().map(DetailProfessorDto::new).collect(Collectors.toList());
    }

    public List<DetailProfessorDto> getAllProfessorsActives(){
        return professorRepository.findAllByIsActiveTrue().stream().map(DetailProfessorDto::new).collect(Collectors.toList());
    }

    public DetailProfessorDto getProfessorById(String id){
        Professor professor= professorRepository.getReferenceById(id);
        return new DetailProfessorDto(professor);
    }

    public DetailProfessorDto getProfessorByName(String name){
        Professor professor = professorRepository.getByName(name);
        return new DetailProfessorDto(professor);
    }

    public void updateProfessor(String id, UpdateProfessorDto professorDto){
        Professor professor = professorRepository.getReferenceById(id);
        professor.updateProfessor(professorDto);
        professorRepository.save(professor);

    }

    public void disableProfessor(String id){
        Professor professor = professorRepository.getReferenceById(id);
        professor.disableAnEmplooye();
        professorRepository.save(professor);
    }

}
