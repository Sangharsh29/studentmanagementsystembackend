package com.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Marks;

import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Integer> {
    List<Marks> findByStudent_StudentId(Integer studentId);
    void deleteByStudent_StudentId(Integer studentId);
}