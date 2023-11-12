package com.example.school_api.services;

import com.example.school_api.domain.Professor;
import com.example.school_api.domain.SchoolSubject;
import com.example.school_api.dtos.CreateProfessorDto;
import com.example.school_api.dtos.DetailProfessorDto;
import com.example.school_api.dtos.UpdateProfessorDto;
import com.example.school_api.infra.exceptions.DuplicatedProfessorException;
import com.example.school_api.infra.exceptions.DuplicatedSubjectException;
import com.example.school_api.infra.exceptions.IsAlreadyDesactivedException;
import com.example.school_api.infra.exceptions.ProfessorNotFoundException;
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

    public Professor createProfessor(CreateProfessorDto professorDto) throws DuplicatedProfessorException, DuplicatedSubjectException {
        SchoolSubject schoolSubject = schoolSubjectRepository.getByName(professorDto.subjectName());
        if(professorRepository.getByNameAndIsActiveTrue(professorDto.name()) != null){
            throw new DuplicatedProfessorException(professorDto.name());
        }

        if(professorRepository.findBySchoolSubjectNameAndIsActiveTrue(professorDto.subjectName()) != null){
            throw new DuplicatedSubjectException(professorDto.subjectName());
        }

        Professor professor = new Professor(professorDto, schoolSubject);
        return professorRepository.save(professor);
    }

    public List<DetailProfessorDto> getAllProfessors(){
        return  professorRepository.findAll().stream().map(DetailProfessorDto::new).collect(Collectors.toList());
    }

    public List<DetailProfessorDto> getAllProfessorsActives(){
        return professorRepository.findAllByIsActiveTrue().stream().map(DetailProfessorDto::new).collect(Collectors.toList());
    }

    public DetailProfessorDto getProfessorById(String id) throws ProfessorNotFoundException {
        Professor professor= professorRepository.findById(id).orElseThrow(()-> new ProfessorNotFoundException());
        return new DetailProfessorDto(professor);
    }

    public DetailProfessorDto getProfessorByName(String name) throws ProfessorNotFoundException {
        Professor professor = professorRepository.getByName(name);
        if(professor == null){
            throw new ProfessorNotFoundException();
        }
        return new DetailProfessorDto(professor);
    }

    public void updateProfessor(String id, UpdateProfessorDto professorDto) throws ProfessorNotFoundException {
        Professor professor = professorRepository.findById(id).orElseThrow(()-> new ProfessorNotFoundException());
        professor.updateProfessor(professorDto);
        professorRepository.save(professor);
    }

    public void disableProfessor(String id) throws ProfessorNotFoundException, IsAlreadyDesactivedException {
        Professor professor = professorRepository.findById(id).orElseThrow(()->new ProfessorNotFoundException());
        if(!professor.getIsActive()){
            throw new IsAlreadyDesactivedException(professor.getName());
        }
        professor.disableAnEmplooye();
        professorRepository.save(professor);
    }

}
