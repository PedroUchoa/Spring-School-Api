package com.example.school_api.controllers;

import com.example.school_api.domain.SchoolReport;
import com.example.school_api.dtos.CreateReportDTO;
import com.example.school_api.dtos.DetailReportDto;
import com.example.school_api.services.SchoolReportService;
import jakarta.transaction.Transactional;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/report")
public class SchoolReportController {

    @Autowired
    private SchoolReportService reportService;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createReport(@RequestBody CreateReportDTO reportDTO, UriComponentsBuilder componentsBuilder){
        SchoolReport schoolReport = reportService.createReport(reportDTO);
        URI uri = componentsBuilder.path("/report/{id}").buildAndExpand(schoolReport.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/student")
    public ResponseEntity<List<DetailReportDto>> getAllReportsWithStudentName(@RequestParam String name){
        List<DetailReportDto> detailReportDtos = reportService.getAllReportsWithStudentName(name);
        return ResponseEntity.ok().body(detailReportDtos);
    }

    @GetMapping("/{semester}")
    public ResponseEntity<List<DetailReportDto>> getAllReportsBySemester(@PathVariable String semester){
        List<DetailReportDto> detailReportDtos = reportService.getAllReportsBySemester(semester);
        return ResponseEntity.ok().body(detailReportDtos);
    }

    @GetMapping("/actived")
    public ResponseEntity<List<DetailReportDto>> getAllReportsActivesWithStudentName(@RequestParam String name){
        List<DetailReportDto> detailReportDtos = reportService.getAllReportsActivesWithStudentName(name);
        return ResponseEntity.ok().body(detailReportDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailReportDto> getReportById(@PathVariable String id){
        DetailReportDto detailReportDto = reportService.getReportById(id);
        return ResponseEntity.ok().body(detailReportDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactiveReport(@PathVariable String id){
        reportService.desactiveReport(id);
        return ResponseEntity.noContent().build();
    }

}
