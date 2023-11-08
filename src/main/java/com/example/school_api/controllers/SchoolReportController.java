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
    public ResponseEntity<Void> createReport(@RequestBody CreateReportDTO reportDTO, UriComponentsBuilder componentsBuilder)throws Exception{
        SchoolReport schoolReport = reportService.createReport(reportDTO);
        URI uri = componentsBuilder.path("/report/{id}").buildAndExpand(schoolReport.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<DetailReportDto>> getAllReports(){
        List<DetailReportDto> detailReportDtos = reportService.getAllReports();
        return ResponseEntity.ok().body(detailReportDtos);
    }

    @GetMapping("/student")
    public ResponseEntity<List<DetailReportDto>> getAllReportsWithStudentName(@RequestParam String name)throws Exception{
        List<DetailReportDto> detailReportDtos = reportService.getAllReportsWithStudentName(name);
        return ResponseEntity.ok().body(detailReportDtos);
    }

    @GetMapping
    public ResponseEntity<List<DetailReportDto>> getAllReportsBySemester(@RequestParam String semester)throws Exception{
        List <DetailReportDto> detailReportDtos = reportService.getReportBySemester(semester);
        return ResponseEntity.ok().body(detailReportDtos);
    }

    @GetMapping("/info")
    public ResponseEntity<DetailReportDto> getAllReportsActivesWithStudentNameAndSemester(@RequestParam String name,@RequestParam String semester)throws Exception{
        DetailReportDto detailReportDtos = reportService.getByStudentNameAndSemester(semester,name);
        return ResponseEntity.ok().body(detailReportDtos);
    }

    @GetMapping("/actives")
    public ResponseEntity<List<DetailReportDto>> getAllReportsActivesWithStudentName(@RequestParam String name)throws Exception{
        List<DetailReportDto> detailReportDtos = reportService.getAllReportsActivesWithStudentName(name);
        return ResponseEntity.ok().body(detailReportDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailReportDto> getReportById(@PathVariable String id)throws Exception{
        DetailReportDto detailReportDto = reportService.getReportById(id);
        return ResponseEntity.ok().body(detailReportDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desactiveReport(@PathVariable String id)throws Exception{
        reportService.desactiveReport(id);
        return ResponseEntity.noContent().build();
    }

}
