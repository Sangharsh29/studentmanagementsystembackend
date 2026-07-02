package com.main.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "attendance")
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendanceId;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String status;
}