package com.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.entity.Marks;
import com.main.repository.MarksRepository;

import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin(origins = "*")
public class MarksController {

    @Autowired
    private MarksRepository marksRepository;

    @PostMapping
    public Marks addMarks(@RequestBody Marks marks) {
        return marksRepository.save(marks);
    }

    @GetMapping("/student/{studentId}")
    public List<Marks> getMarksByStudent(@PathVariable Integer studentId) {
        return marksRepository.findByStudent_StudentId(studentId);
    }
}