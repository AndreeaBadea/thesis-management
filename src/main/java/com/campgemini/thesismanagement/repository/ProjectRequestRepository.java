package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.ProjectRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ProjectRequestRepository extends JpaRepository<ProjectRequest, Integer> {

}
