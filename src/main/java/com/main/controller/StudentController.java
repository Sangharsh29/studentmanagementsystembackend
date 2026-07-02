package com.main.controller;

import com.main.entity.Student;
import com.main.repository.AttendanceRepository;
import com.main.repository.MarksRepository;
import com.main.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private MarksRepository marksRepository;

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestBody Student updated) {

        Student student = studentRepository.findById(id).orElseThrow();

        student.setName(updated.getName());
        student.setClassName(updated.getClassName());
        student.setMobileNo(updated.getMobileNo());
        student.setAddress(updated.getAddress());

        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        attendanceRepository.deleteByStudent_StudentId(id);

        marksRepository.deleteByStudent_StudentId(id);

        studentRepository.deleteById(id);

        return "Student Deleted Successfully";
    }
}