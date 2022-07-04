package com.campgemini.thesismanagement.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="projects_requests")
public class ProjectRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project_request")
    private Integer idProjectRequest;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student")
    private Student student;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_project")
    private Project project;
}
