package com.campgemini.thesismanagement.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "students_skills")
public class StudentSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student_skill")
    private Integer idStudentSkill;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student")
    private Student idStudent;

    @Column(name = "skills_name")
    private String skillsName;

    @Column(name = "work_experience")
    private String workExperience;
}
