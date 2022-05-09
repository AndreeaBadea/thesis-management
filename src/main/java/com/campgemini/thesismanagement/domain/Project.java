package com.campgemini.thesismanagement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_project")
    private Integer idProject;

    @OneToOne(mappedBy = "student" )
    private StudentProject studentProject; //

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_teacher")
    @JsonIgnore
    private Teacher teacher;

    @Column(name = "project_title")
    private String projectTitle;

    @NotEmpty
    @Column(name = "project_description")
    private String projectDescription;

    @Column(name = "project_availability")
    private Boolean projectAvailability;
}
