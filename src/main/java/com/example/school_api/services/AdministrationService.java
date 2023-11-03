package com.example.school_api.services;

import com.example.school_api.domain.Administration;
import com.example.school_api.dtos.CreateAdministrationDto;
import com.example.school_api.dtos.DetailAdministrationDto;
import com.example.school_api.repositories.AdministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministrationService {

    @Autowired
    private AdministrationRepository administrationRepository;

    public Administration createAdministration(CreateAdministrationDto administrationDto){
        Administration administration = new Administration(administrationDto);
       return administrationRepository.save(administration);
    }

    public List<DetailAdministrationDto> listAllAdministrations(){
        return administrationRepository.findAll().stream().map(DetailAdministrationDto::new).collect(Collectors.toList());
    }

    public List<DetailAdministrationDto> listAllAdministrationsActivated(){
        return administrationRepository.findAllByIsActiveTrue().stream().map(DetailAdministrationDto::new).collect(Collectors.toList());
    }

    public List<DetailAdministrationDto> findByFunctions(String function){
        return administrationRepository.findAllByFunctionalAndIsActiveTrue(function).stream().map(DetailAdministrationDto::new).collect(Collectors.toList());
    }

    public DetailAdministrationDto findById(String id){
        Administration administration = administrationRepository.getReferenceById(id);
        return new DetailAdministrationDto(administration);
    }

    public DetailAdministrationDto findByName(String name){
        Administration administration = administrationRepository.getByName(name);
        return new DetailAdministrationDto(administration);
    }

    public void updatAdministration(String id, CreateAdministrationDto administrationDto){
        Administration administration = administrationRepository.getReferenceById(id);
        administration.updateAdministration(administrationDto);
        administrationRepository.save(administration);
    }

    public void disableAdministration(String id){
        Administration administration = administrationRepository.getReferenceById(id);
        administration.disableAnEmplooye();
        administrationRepository.save(administration);
    }



}
