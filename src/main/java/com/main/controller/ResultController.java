package com.main.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.service.ResultService;

import java.util.Map;

@RestController
@RequestMapping("/api/result")
@CrossOrigin(origins = "*")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/{studentId}")
    public Map<String, Object> getResult(@PathVariable Integer studentId) {
        return resultService.getResult(studentId);
    }
}