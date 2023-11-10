package com.example.school_api.controllers;

import com.example.school_api.domain.Administration;
import com.example.school_api.dtos.CreateAdministrationDto;
import com.example.school_api.dtos.DetailAdministrationDto;
import com.example.school_api.services.AdministrationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/administration")
public class AdministrationController {

    @Autowired
    private AdministrationService administrationService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createAdministration(@RequestBody CreateAdministrationDto createAdministrationDto, UriComponentsBuilder componentsBuilder)throws Exception{
        Administration administration = administrationService.createAdministration(createAdministrationDto);
        URI uri = componentsBuilder.path("/administration/{id}").buildAndExpand(administration.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetailAdministrationDto>> listAllAdministrations(){
        List<DetailAdministrationDto> administrationDtos = administrationService.listAllAdministrations();
        return ResponseEntity.ok().body(administrationDtos);
    }

    @GetMapping("/actives")
    public ResponseEntity<List<DetailAdministrationDto>> listAllAdministrationsActivated(){
        List<DetailAdministrationDto> administrationDtos = administrationService.listAllAdministrationsActivated();
        return ResponseEntity.ok().body(administrationDtos);
    }

    @GetMapping("/function/{function}")
    public ResponseEntity<List<DetailAdministrationDto>> findByFunctions(@PathVariable String function){
        List<DetailAdministrationDto> administrationDto = administrationService.findByFunctions(function);
        return ResponseEntity.ok().body(administrationDto);
    }

    @GetMapping("/value/{id}")
    public ResponseEntity<DetailAdministrationDto> findById(@PathVariable String id) throws Exception{
        DetailAdministrationDto administrationDto = administrationService.findById(id);
        return ResponseEntity.ok().body(administrationDto);
    }

    @GetMapping("/{name}")
    public ResponseEntity<DetailAdministrationDto> findByName(@PathVariable String name) throws Exception{
        DetailAdministrationDto administrationDto = administrationService.findByName(name);
        return ResponseEntity.ok().body(administrationDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> updatAdministration(@PathVariable String id, @RequestBody CreateAdministrationDto administrationDto) throws Exception{
        administrationService.updatAdministration(id,administrationDto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> disableAdministration(@PathVariable String id)throws Exception{
        administrationService.disableAdministration(id);
        return ResponseEntity.noContent().build();
    }


}
