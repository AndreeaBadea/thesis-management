package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
