package com.campgemini.thesismanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetailsDto {

    private Integer idStudent;

    @JsonIgnore
    private UserAccount userAccount;

    private Integer idUserAccount;

    private String email;

    private String firstName;

    private String lastName;

    private String faculty;

    private String facultyDomain;

    private String classroom;

    @JsonIgnore
    private StudentProject studentProject;

    private Integer idStudentProject;

    private String status;

}
