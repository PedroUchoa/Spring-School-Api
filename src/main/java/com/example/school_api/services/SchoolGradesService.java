package com.example.school_api.services;

import com.example.school_api.domain.SchoolGrades;
import com.example.school_api.domain.SchoolReport;
import com.example.school_api.domain.SchoolSubject;
import com.example.school_api.dtos.CreateGradeDto;
import com.example.school_api.dtos.UpdateGradeDto;
import com.example.school_api.repositories.SchoolGradesRepository;
import com.example.school_api.repositories.SchoolReportRepository;
import com.example.school_api.repositories.SchoolSubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolGradesService {

    @Autowired
    private SchoolGradesRepository schoolGradesRepository;

    @Autowired
    private SchoolReportRepository schoolReportRepository;

    @Autowired
    private SchoolSubjectRepository schoolSubjectRepository;

    public void createGrades(CreateGradeDto gradesDto){
        SchoolReport report = schoolReportRepository.getReferenceById(gradesDto.reportId());
        SchoolSubject subject = schoolSubjectRepository.getByName(gradesDto.subjectName());
        SchoolGrades grades = new SchoolGrades(gradesDto, report,subject);
    }

    public void updateGrades(UpdateGradeDto gradeDto, String id){
        SchoolGrades grades = schoolGradesRepository.getReferenceById(id);
        grades.updateGrades(gradeDto);
    }

}
