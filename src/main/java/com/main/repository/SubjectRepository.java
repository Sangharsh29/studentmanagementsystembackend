package com.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    boolean existsBySubjectName(String subjectName);
}