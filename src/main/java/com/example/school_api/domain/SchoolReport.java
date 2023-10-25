package com.example.school_api.domain;

import jakarta.persistence.*;
import lombok.*;

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
    @OneToMany(mappedBy = "report", cascade = CascadeType.PERSIST)
    private Set<SchoolGrades> schoolGrades;

    @ManyToOne
    @JoinTable(name = "report_student",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "school_report_id")})
    private Student student;

}
