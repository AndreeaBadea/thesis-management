package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
