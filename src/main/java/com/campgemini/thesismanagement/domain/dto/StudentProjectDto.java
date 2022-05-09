package com.campgemini.thesismanagement.domain.dto;

import com.campgemini.thesismanagement.domain.Project;
import com.campgemini.thesismanagement.domain.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProjectDto {

    private Integer idStudentProject;

    private Integer idStudent;

    private Integer idProject;

    @JsonIgnore
    private Student student;

    @JsonIgnore
    private Project project;


}
