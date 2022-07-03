package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.TeacherSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherSkillRepository extends JpaRepository<TeacherSkill, Integer> {


}
