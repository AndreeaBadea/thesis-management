package com.campgemini.thesismanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher")
    private Integer idTeacher;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_account")
    private UserAccount id_user_account;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cnp")
    private String CNP;

    @Column(name = "number_of_students")
    private Integer numberOfStudents;

    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Project> projectsList;
}
