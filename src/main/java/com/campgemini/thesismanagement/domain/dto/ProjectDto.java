package com.campgemini.thesismanagement.domain.dto;

import com.campgemini.thesismanagement.domain.StudentProject;
import com.campgemini.thesismanagement.domain.Teacher;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {

    private Integer idProject;

    @JsonIgnore
    private StudentProject studentProject;

    @JsonIgnore
    private Integer idStudentProject;

    @JsonIgnore
    private Teacher teacher;

    private Integer idTeacher;

    private String projectTitle;

    private String projectDescription;

    private Boolean projectAvailability;




}
