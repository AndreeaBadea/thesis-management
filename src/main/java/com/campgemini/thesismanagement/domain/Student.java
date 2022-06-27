package com.campgemini.thesismanagement.domain;

import com.campgemini.thesismanagement.domain.dto.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Email;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private Integer idStudent;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user_account")
    private UserAccount userAccount;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "cnp")
    private String CNP;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "faculty_domain")
    private String facultyDomain;

    @Column(name = "classroom")
    private String classroom;

    @OneToOne(mappedBy = "student" )
    private StudentProject studentProject;

    public void setIdUserAccount(Integer id){
        userAccount.setIdUserAccount(id);
    }

    public void setEmail(String email){
        userAccount.setEmail(email);
    }

}
