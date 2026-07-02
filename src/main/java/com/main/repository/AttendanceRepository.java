package com.main.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.main.entity.Attendance;
import java.util.Optional;
import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
    List<Attendance> findByDate(LocalDate date);
    List<Attendance> findByStudent_StudentId(Integer studentId);
    Optional<Attendance> findByStudent_StudentIdAndDate(Integer studentId,
                                                        LocalDate date);
    void deleteByStudent_StudentId(Integer studentId);
}