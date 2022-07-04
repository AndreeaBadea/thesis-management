package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.StudentSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentSkillRepository extends JpaRepository<StudentSkill, Integer> {
}
