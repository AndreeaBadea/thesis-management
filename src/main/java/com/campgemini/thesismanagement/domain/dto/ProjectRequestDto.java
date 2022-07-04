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
public class ProjectRequestDto {

    private Integer idProjectRequest;

    @JsonIgnore
    private Student student;

    private Integer idStudent;

    private String studentName;

    @JsonIgnore
    private Project project;

    private String projectTitle;

}
