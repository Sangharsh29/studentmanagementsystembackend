package com.main.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subjects")
@Data
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectId;

    @Column(unique = true, columnDefinition = "VARCHAR(100) COLLATE utf8mb4_bin")
    private String subjectName;
}