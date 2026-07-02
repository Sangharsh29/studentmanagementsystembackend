package com.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByNameContainingIgnoreCase(String name);
}