package com.example.school_api.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private Double salary;
    private String phone;
    @CreationTimestamp
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Boolean isActive = true;

    public Employee(String name, String phone, Double salary) {
        this.name = name;
        this.phone = phone;
        this.salary =salary;
    }

    public void disableAnEmplooye(){
        setIsActive(false);
        setEndDate(LocalDateTime.now());
    }



}
