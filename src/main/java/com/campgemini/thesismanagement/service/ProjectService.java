package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.Project;
import com.campgemini.thesismanagement.domain.StudentProject;
import com.campgemini.thesismanagement.domain.dto.ProjectDto;
import com.campgemini.thesismanagement.domain.dto.StudentProjectDto;
import com.campgemini.thesismanagement.repository.ProjectRepository;
import com.campgemini.thesismanagement.repository.StudentProjectRepository;
import com.campgemini.thesismanagement.repository.StudentRepository;
import com.campgemini.thesismanagement.repository.TeacherRepository;
import com.campgemini.thesismanagement.service.mapper.ProjectMapper;
import com.campgemini.thesismanagement.service.mapper.StudentProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    private final TeacherRepository teacherRepository;

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final StudentProjectRepository studentProjectRepository;


    public ProjectService(ProjectRepository projectRepository, TeacherRepository teacherRepository, StudentRepository studentRepository, StudentProjectRepository studentProjectRepository) {
        this.projectRepository = projectRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.studentProjectRepository = studentProjectRepository;
    }

    public List<ProjectDto> findAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

    public ProjectDto findProjectById(int id){
        return ProjectMapper.projectToProjectDto(projectRepository.getById(id));
    }

    public List<StudentProjectDto> getAllAllocatedProjects(){
        return studentProjectRepository.findAll()
                .stream()
                .map(StudentProjectMapper::toStudentProjectDto)
                .collect(Collectors.toList());
    }


}
