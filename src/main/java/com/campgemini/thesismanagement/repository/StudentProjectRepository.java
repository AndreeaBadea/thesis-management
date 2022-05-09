package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.StudentProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentProjectRepository extends JpaRepository<StudentProject, Integer> {
}
