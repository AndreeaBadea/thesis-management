package com.campgemini.thesismanagement.domain.dto;

import com.campgemini.thesismanagement.domain.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSkillDto {

    private Integer idStudentSkills;

    @JsonIgnore
    private Student student;

    private Integer idStudent;

    private String skillsName;

    private String workExperience;
}
