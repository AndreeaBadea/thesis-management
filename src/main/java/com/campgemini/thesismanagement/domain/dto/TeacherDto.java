package com.campgemini.thesismanagement.domain.dto;

import com.campgemini.thesismanagement.domain.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherDto {

    private Integer idTeacher;
    private String firstName;
    private String lastName;
    private String email;
    private String CNP;
    private Integer numberOfStudents;

    private List<Project> projectsList;

}
