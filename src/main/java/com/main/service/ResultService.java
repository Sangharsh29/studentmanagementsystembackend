package com.main.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Marks;
import com.main.repository.MarksRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResultService {

    @Autowired
    private MarksRepository marksRepository;

    public Map<String, Object> getResult(Integer studentId) {
        List<Marks> marksList = marksRepository.findByStudent_StudentId(studentId);

        int totalMax = 0, totalObtained = 0;
        for (Marks m : marksList) {
            totalMax += m.getMaxMarks();
            totalObtained += m.getMarksObtained();
        }

        double percentage = totalMax == 0 ? 0 : (totalObtained * 100.0) / totalMax;
        String result = percentage >= 35 ? "Pass" : "Fail";

        Map<String, Object> response = new HashMap<>();
        response.put("studentId", studentId);
        response.put("marksList", marksList);
        response.put("totalObtained", totalObtained);
        response.put("totalMax", totalMax);
        response.put("percentage", Math.round(percentage * 100.0) / 100.0);
        response.put("result", result);
        return response;
    }
}