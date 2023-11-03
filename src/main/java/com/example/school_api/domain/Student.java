package com.example.school_api.domain;


import com.example.school_api.dtos.CreateStudentDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "students")
@Entity(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private boolean isActive = true;
    private String phone;
    @CreationTimestamp
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "student", cascade = CascadeType.PERSIST)
    @JsonBackReference
    private List<SchoolReport> schoolReport;

    public Student(CreateStudentDto student) {
        this.name = student.name();
        this.phone = student.phone();
    }

    public void updateStudent(CreateStudentDto studentDto) {
        if(studentDto.name() != null && !studentDto.name().isEmpty()){
            this.name = studentDto.name();
        }

        if(studentDto.phone() != null && !studentDto.phone().isEmpty()){
            this.phone = studentDto.phone();
        }

    }
}
