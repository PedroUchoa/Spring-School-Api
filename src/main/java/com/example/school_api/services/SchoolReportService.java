package com.example.school_api.services;

import com.example.school_api.domain.SchoolReport;
import com.example.school_api.domain.Student;
import com.example.school_api.dtos.CreateReportDTO;
import com.example.school_api.dtos.DetailReportDto;
import com.example.school_api.repositories.SchoolReportRepository;
import com.example.school_api.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolReportService {

    @Autowired
    private SchoolReportRepository schoolReportRepository;

    @Autowired
    private StudentRepository studentRepository;

    public SchoolReport createReport(CreateReportDTO reportDto){
        Student student = studentRepository.findByName(reportDto.studentName());
        SchoolReport report = new SchoolReport(reportDto,student);
        schoolReportRepository.save(report);
        return report;
    }

    public List<DetailReportDto> getAllReportsWithStudentName(String name){
        return schoolReportRepository.findAllReportByStudentName(name).stream().map(DetailReportDto::new).collect(Collectors.toList());
    }

    public List<DetailReportDto> getAllReportsBySemester(String semester){
        return schoolReportRepository.findAlBySemester(semester).stream().map(DetailReportDto::new).collect(Collectors.toList());
    }

    public List<DetailReportDto> getAllReportsActivesWithStudentName(String name){
        return schoolReportRepository.findAllReportByisActiveTrueAndStudentName(name).stream().map(DetailReportDto::new).collect(Collectors.toList());
    }

    public DetailReportDto getReportById(String id){
        SchoolReport schoolReportDto = schoolReportRepository.getReferenceById(id);
        return new DetailReportDto(schoolReportDto);
    }

    public void desactiveReport(String id){
        SchoolReport report = schoolReportRepository.getReferenceById(id);
        report.desactiveReport();
        schoolReportRepository.save(report);
    }


}
