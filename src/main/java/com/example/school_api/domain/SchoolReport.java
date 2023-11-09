package com.example.school_api.domain;

import com.example.school_api.dtos.CreateReportDTO;
import com.example.school_api.dtos.UpdateGradeDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Set;

@Table(name = "schoolReport")
@Entity(name = "SchoolReport")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class SchoolReport {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String semester;
    private Boolean isActive = true;
    @CreationTimestamp
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @OneToMany(mappedBy = "report", cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Set<SchoolGrades> schoolGrades;

    @ManyToOne
    @JoinTable(name = "report_student",
            joinColumns = {@JoinColumn(name = "school_report_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")})
    @JsonManagedReference
    @JsonIgnore
    private Student student;

    public SchoolReport(String semester, Student student) {
        this.semester = semester;
        this.student = student;
    }

    public void desactiveReport() {
        this.isActive = false;
        this.endDate = LocalDateTime.now();
    }

}
