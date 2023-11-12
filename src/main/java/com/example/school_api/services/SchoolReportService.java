package com.example.school_api.services;

import com.example.school_api.domain.SchoolReport;
import com.example.school_api.domain.Student;
import com.example.school_api.dtos.CreateReportDTO;
import com.example.school_api.dtos.DetailReportDto;
import com.example.school_api.infra.exceptions.*;
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

    public SchoolReport createReport(CreateReportDTO reportDto) throws StudentNotFoundException, IsAlreadyDesactivedException, SemesterDuplicatedException {
        Student student = studentRepository.findByName(reportDto.studentName());
        if(student == null){
            throw new StudentNotFoundException();
        }
        if(!student.isActive()){
            throw new IsAlreadyDesactivedException(student.getName());
        }
        if(schoolReportRepository.findBySemesterAndStudentName(reportDto.semester(),reportDto.studentName()) != null){
            throw new SemesterDuplicatedException(reportDto.semester());
        }
        SchoolReport report = new SchoolReport(reportDto.semester(), student);
        return schoolReportRepository.save(report);

    }

    public List<DetailReportDto> getAllReports(){
        return schoolReportRepository.findAll().stream().map(DetailReportDto::new).collect(Collectors.toList());
    }

    public List<DetailReportDto> getAllReportsWithStudentName(String name) throws StudentNotFoundException {
        Student student = studentRepository.findByName(name);
        if(student == null){
            throw new StudentNotFoundException();
        }
        return schoolReportRepository.findAllReportByStudentName(name).stream().map(DetailReportDto::new).collect(Collectors.toList());
    }

    public List<DetailReportDto> getReportBySemester(String semester) throws SemesterNotFoundException {
        List<SchoolReport> report =  schoolReportRepository.findAllBySemester(semester);
        if (report.isEmpty()){
            throw new SemesterNotFoundException();
        }
        return report.stream().map(DetailReportDto::new).collect(Collectors.toList());
    }

    public DetailReportDto getByStudentNameAndSemester(String semester, String name) throws ReportNotFoundException {

        SchoolReport report = schoolReportRepository.findBySemesterAndStudentName(semester, name);

        if(report == null){
        throw new ReportNotFoundException();
        }
        return new DetailReportDto(report);
    }


    public List<DetailReportDto> getAllReportsActivesWithStudentName(String name) throws StudentNotFoundException {
        Student student = studentRepository.findByName(name);
        if(student == null){
            throw new StudentNotFoundException();
        }

        return schoolReportRepository.findAllReportByisActiveTrueAndStudentName(name).stream().map(DetailReportDto::new).collect(Collectors.toList());
    }

    public DetailReportDto getReportById(String id) throws ReportNotFoundException {
        SchoolReport schoolReportDto = schoolReportRepository.findById(id).orElseThrow(()-> new ReportNotFoundException());
        return new DetailReportDto(schoolReportDto);
    }

    public void desactiveReport(String id) throws ReportNotFoundException, IsAlreadyDesactivedException {
        SchoolReport report = schoolReportRepository.findById(id).orElseThrow(()-> new ReportNotFoundException());
        if(!report.getIsActive()){
            throw new IsAlreadyDesactivedException("Report");
        }
        report.desactiveReport();
        schoolReportRepository.save(report);
    }


}
