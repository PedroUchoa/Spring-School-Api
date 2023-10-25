package com.example.school_api.domain;


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
    private List<SchoolReport> schoolReport;

}
