package com.example.school_api.domain;

import com.example.school_api.dtos.CreateClassroomDto;
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
    private SchoolGeneral schoolGeneral;

    public Classroom(CreateClassroomDto classroomDto) {
        this.name = classroomDto.name();
        this.localization = classroomDto.localization();
    }

    public void updateClassroom(CreateClassroomDto classroomDto) {
        if(classroomDto.name() != null && !classroomDto.name().isEmpty()){
            this.name = classroomDto.name();
        }
        if(classroomDto.localization() != null && !classroomDto.localization().isEmpty()){
            this.localization = classroomDto.localization();
        }

    }
}
