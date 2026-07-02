package com.main.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "marks")
@Data
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer marksId;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String subjectName;
    private Integer maxMarks;
    private Integer marksObtained;
}