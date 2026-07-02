package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.entity.Attendance;
import com.main.repository.AttendanceRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @PostMapping
    public Attendance markAttendance(@RequestBody Attendance attendance) {

        if(attendance.getDate().isAfter(LocalDate.now())){
            throw new RuntimeException("Future attendance is not allowed.");
        }

        Attendance existing =
                attendanceRepository
                .findByStudent_StudentIdAndDate(
                        attendance.getStudent().getStudentId(),
                        attendance.getDate())
                .orElse(null);

        if(existing != null){

            existing.setStatus(attendance.getStatus());

            return attendanceRepository.save(existing);
        }

        return attendanceRepository.save(attendance);
    }

    @GetMapping("/date/{date}")
    public List<Attendance> getByDate(@PathVariable String date) {
        return attendanceRepository.findByDate(LocalDate.parse(date));
    }

    @GetMapping("/student/{studentId}")
    public List<Attendance> getByStudent(@PathVariable Integer studentId) {
        return attendanceRepository.findByStudent_StudentId(studentId);
    }
}