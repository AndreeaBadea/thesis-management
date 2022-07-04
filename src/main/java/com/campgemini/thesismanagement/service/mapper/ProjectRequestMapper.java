package com.campgemini.thesismanagement.service.mapper;

import com.campgemini.thesismanagement.domain.ProjectRequest;
import com.campgemini.thesismanagement.domain.dto.ProjectRequestDto;

public class ProjectRequestMapper {

    public static ProjectRequestDto projectRequestToProjectRequestDto(ProjectRequest projectRequest){
        ProjectRequestDto projectRequestDto = new ProjectRequestDto();
        projectRequestDto.setIdProjectRequest(projectRequest.getIdProjectRequest());
        projectRequestDto.setStudent(projectRequest.getStudent());
        projectRequestDto.setStudentName(projectRequest.getStudent().getFirstName() + " "
                + projectRequest.getStudent().getLastName());
        projectRequestDto.setProject(projectRequest.getProject());
        projectRequestDto.setProjectTitle(projectRequest.getProject().getProjectTitle());
        return projectRequestDto;
    }

    public static ProjectRequest projectRequestDtoToProjectRequest(ProjectRequestDto projectRequestDto){
        ProjectRequest projectRequest = new ProjectRequest();
        projectRequest.setIdProjectRequest(projectRequestDto.getIdProjectRequest());
        projectRequest.setStudent(projectRequestDto.getStudent());
        projectRequest.setProject(projectRequestDto.getProject());
        return projectRequest;
    }

}
