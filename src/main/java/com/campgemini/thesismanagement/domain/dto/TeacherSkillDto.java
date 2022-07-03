package com.campgemini.thesismanagement.domain.dto;

import com.campgemini.thesismanagement.domain.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherSkillDto {

    private Integer idTeachersSkills;

    @JsonIgnore
    private Teacher teacher;

    private Integer idTeacher;

    private String skillsName;

    private String teachingSubjects;


}
