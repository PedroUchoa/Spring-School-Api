package com.example.school_api.services;

import com.example.school_api.domain.Administration;
import com.example.school_api.dtos.CreateAdministrationDto;
import com.example.school_api.dtos.DetailAdministrationDto;
import com.example.school_api.infra.exceptions.AdministrationNotFoundException;
import com.example.school_api.infra.exceptions.DuplicatedAdministrationException;
import com.example.school_api.infra.exceptions.IsAlreadyDesactivedException;
import com.example.school_api.repositories.AdministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministrationService {

    @Autowired
    private AdministrationRepository administrationRepository;

    public Administration createAdministration(CreateAdministrationDto administrationDto) throws DuplicatedAdministrationException {
        Administration administration = new Administration(administrationDto);
        if(administrationRepository.findByNameAndIsActiveTrue(administrationDto.name()) != null){
            throw new DuplicatedAdministrationException(administrationDto.name());
        }
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

    public DetailAdministrationDto findById(String id) throws AdministrationNotFoundException {
        Administration administration = administrationRepository.findById(id).orElseThrow(()->new AdministrationNotFoundException());
        return new DetailAdministrationDto(administration);
    }

    public DetailAdministrationDto findByName(String name) throws AdministrationNotFoundException {
        Administration administration = administrationRepository.getByName(name);
        if(administration == null){
            throw new AdministrationNotFoundException();
        }
        return new DetailAdministrationDto(administration);
    }

    public void updatAdministration(String id, CreateAdministrationDto administrationDto) throws AdministrationNotFoundException {
        Administration administration = administrationRepository.findById(id).orElseThrow(()->new AdministrationNotFoundException());
        administration.updateAdministration(administrationDto);
        administrationRepository.save(administration);
    }

    public void disableAdministration(String id) throws AdministrationNotFoundException, IsAlreadyDesactivedException {
        Administration administration = administrationRepository.findById(id).orElseThrow(()-> new AdministrationNotFoundException());
        if(!administration.getIsActive()){
            throw new IsAlreadyDesactivedException(administration.getName());
        }
        administration.disableAnEmplooye();
        administrationRepository.save(administration);
    }



}
