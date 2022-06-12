package com.campgemini.thesismanagement.domain.dto;

import com.campgemini.thesismanagement.domain.Project;
import com.campgemini.thesismanagement.domain.UserAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private Integer idTeacher;

    @JsonIgnore
    private UserAccount userAccount;

    private Integer idUserAccount;

    private String firstName;

    private String lastName;

    private String CNP;

    private Integer numberOfStudents;

    private List<Project> projectsList;

}
