package com.example.school_api.services;

import com.example.school_api.domain.SchoolGrades;
import com.example.school_api.domain.SchoolReport;
import com.example.school_api.domain.SchoolSubject;
import com.example.school_api.dtos.CreateGradeDto;
import com.example.school_api.dtos.DetailGradesDto;
import com.example.school_api.dtos.UpdateGradeDto;
import com.example.school_api.infra.exceptions.*;
import com.example.school_api.repositories.SchoolGradesRepository;
import com.example.school_api.repositories.SchoolReportRepository;
import com.example.school_api.repositories.SchoolSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolGradesService {

    @Autowired
    private SchoolGradesRepository schoolGradesRepository;

    @Autowired
    private SchoolReportRepository schoolReportRepository;

    @Autowired
    private SchoolSubjectRepository schoolSubjectRepository;

    public SchoolGrades createGrades(CreateGradeDto gradesDto) throws ReportNotFoundException, SubjectNotFoundException, IsAlreadyDesactivedException, DuplicatedSubjectException {
        SchoolReport report = schoolReportRepository.findBySemesterAndStudentName(gradesDto.reportSemester(), gradesDto.studentName());
        SchoolSubject subject = schoolSubjectRepository.getByName(gradesDto.subjectName());
        if(report == null){
            throw new ReportNotFoundException();
        }
        if(schoolReportRepository.findReportBySemesterAndStudentNameAndSchoolGradesSchoolSubjectName(gradesDto.reportSemester(),gradesDto.studentName(),gradesDto.subjectName()) != null){
            throw new DuplicatedSubjectException(gradesDto.subjectName());
        }
        if(!report.getStudent().isActive()){
            throw new IsAlreadyDesactivedException(report.getStudent().getName());
        }
        if(!report.getIsActive()){
            throw new IsAlreadyDesactivedException("report");
        }
        if(subject == null){
            throw new SubjectNotFoundException();
        }

        SchoolGrades grades = new SchoolGrades(gradesDto, report,subject);
        return schoolGradesRepository.save(grades);

    }

    public List<DetailGradesDto> getGradesByNameAndSemester(String name, String semester){
        return schoolGradesRepository.findAllByReportStudentNameAndReportSemester(name,semester).stream().map(DetailGradesDto::new).collect(Collectors.toList());
    }

    public void updateGrades(UpdateGradeDto gradeDto, String id) throws GradesNotFoundException {
        SchoolGrades grades = schoolGradesRepository.findById(id).orElseThrow(()->new GradesNotFoundException());
        grades.updateGrades(gradeDto);
        schoolGradesRepository.save(grades);
    }

}
