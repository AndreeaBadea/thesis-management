package com.campgemini.thesismanagement.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="teachers_skills")
public class TeacherSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teachers_skills")
    private Integer idTeachersSkills;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_teacher")
    private Teacher idTeacher;

    @Column(name = "skills_name")
    private String skillsName;

    @Column(name = "teaching_subjects")
    private String teachingSubjects;



}
