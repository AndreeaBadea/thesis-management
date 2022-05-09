package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
