package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.StudentProject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentProjectRepository extends JpaRepository<StudentProject, Integer> {

//    public List<StudentProject> findAll();
}
