package com.campgemini.thesismanagement.service.mapper;

import com.campgemini.thesismanagement.domain.Project;
import com.campgemini.thesismanagement.domain.dto.ProjectDto;

public class ProjectMapper {

    public static ProjectDto projectToProjectDto(Project project){
        ProjectDto projectDto = new ProjectDto();
        projectDto.setIdProject(project.getIdProject());
      //  projectDto.setStudentProject(project.getStudentProject());
      //  projectDto.setIdStudentProject(project.getStudentProject().getIdStudentProject());
        projectDto.setTeacher(project.getTeacher());
        projectDto.setIdTeacher(project.getTeacher().getIdTeacher());
        projectDto.setProjectTitle(project.getProjectTitle());
        projectDto.setProjectDescription(project.getProjectDescription());
        projectDto.setProjectAvailability(project.getProjectAvailability());
        return projectDto;
    }


    public static Project projectDtoToProject(ProjectDto projectDto){
        Project project = new Project();
        project.setIdProject(projectDto.getIdProject());
      //  project.setStudent(projectDto.getStudent());
        project.setStudentProject(projectDto.getStudentProject());
        project.setTeacher(projectDto.getTeacher());
        project.setProjectTitle(projectDto.getProjectTitle());
        project.setProjectDescription(projectDto.getProjectDescription());
        project.setProjectAvailability(projectDto.getProjectAvailability());
        return project;
    }

}
