package com.example.school_api.services;

import com.example.school_api.domain.Classroom;
import com.example.school_api.domain.SchoolGeneral;
import com.example.school_api.dtos.CreateGeneralServiceDto;
import com.example.school_api.dtos.DetailGeneralServiceDto;
import com.example.school_api.repositories.ClassroomRepository;
import com.example.school_api.repositories.GeneralServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneralService {

    @Autowired
    private GeneralServiceRepository generalServiceRepository;

    @Autowired
    private ClassroomRepository classroomRepository;


    public SchoolGeneral createGeneralService(CreateGeneralServiceDto generalDto){
        Classroom classroom = classroomRepository.getByName(generalDto.name());
        SchoolGeneral schoolGeneral = new SchoolGeneral(generalDto,classroom);
        return generalServiceRepository.save(schoolGeneral);
    }

    public List<DetailGeneralServiceDto> getAllGeneral(){
        return generalServiceRepository.findAll().stream().map(DetailGeneralServiceDto::new).collect(Collectors.toList());
    }

    public List<DetailGeneralServiceDto> getAllGeneralActives(){
        return generalServiceRepository.findAllByIsActiveTrue().stream().map(DetailGeneralServiceDto::new).collect(Collectors.toList());
    }

    public DetailGeneralServiceDto getGeneralById(String id){
        SchoolGeneral schoolGeneral = generalServiceRepository.getReferenceById(id);
        return new DetailGeneralServiceDto(schoolGeneral);
    }

    public DetailGeneralServiceDto getGeneralByName(String name){
        SchoolGeneral schoolGeneral = generalServiceRepository.getByName(name);
        return new DetailGeneralServiceDto(schoolGeneral);
    }

    public void updateGeneral(String id, CreateGeneralServiceDto generalDto){
        SchoolGeneral general =generalServiceRepository.getReferenceById(id);
        Classroom classroom = classroomRepository.getByName(generalDto.classroomName());
        general.updateGeneral(generalDto, classroom);
        generalServiceRepository.save(general);
    }

    public void desactiveGeneral(String id){
        SchoolGeneral general =generalServiceRepository.getReferenceById(id);
        general.disableAnEmplooye();
        generalServiceRepository.save(general);
    }


}
