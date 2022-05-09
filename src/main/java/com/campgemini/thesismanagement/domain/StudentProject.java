package com.campgemini.thesismanagement.domain;

import com.campgemini.thesismanagement.domain.Project;
import com.campgemini.thesismanagement.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="students_projects")
public class StudentProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_student_project")
    private Integer idStudentProject;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "id_student")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "id_project")
    private Project project;





}
