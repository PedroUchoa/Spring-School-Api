package com.example.school_api.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "schoolGrades")
@Entity(name = "SchoolGrades")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class SchoolGrades {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private Double firstGrade;
    private Double secondGrade;
    @ManyToOne
    @JoinTable(name = "subject_grades",
            joinColumns = {@JoinColumn(name = "school_grades_id")},
            inverseJoinColumns = {@JoinColumn(name = "school_subject_id")})
    private SchoolSubject schoolSubject;

    @ManyToOne
    @JoinTable(name = "report_grades",
            joinColumns = {@JoinColumn(name = "school_grades_id")},
            inverseJoinColumns = {@JoinColumn(name = "school_report_id")})
    private SchoolReport report;

}
