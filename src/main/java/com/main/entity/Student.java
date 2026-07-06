package com.main.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @Column(nullable = false, unique = true)
    private Integer studentId;

    private String name;
    private String className;
    private String mobileNo;
    private String address;
}