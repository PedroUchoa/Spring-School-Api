package com.example.school_api.domain;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "classrooms")
@Entity(name = "Classroom")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String localization;
    @OneToOne(mappedBy = "classroom")
    private GeneralService generalService;

}
