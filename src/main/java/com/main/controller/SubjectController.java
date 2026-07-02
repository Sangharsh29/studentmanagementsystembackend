package com.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.entity.Subject;
import com.main.repository.SubjectRepository;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
@CrossOrigin(origins = "*")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @PostMapping
    public Object addSubject(@RequestBody Subject subject) {
        if (subjectRepository.existsBySubjectName(subject.getSubjectName())) {
            return "DUPLICATE";
        }
        return subjectRepository.save(subject);
    }
    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }
}