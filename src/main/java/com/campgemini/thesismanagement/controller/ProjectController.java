package com.campgemini.thesismanagement.controller;

import com.campgemini.thesismanagement.domain.dto.ProjectDto;
import com.campgemini.thesismanagement.domain.dto.StudentProjectDto;
import com.campgemini.thesismanagement.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value ="http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping()
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return new ResponseEntity<>(projectService.findAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable int id) {
        return new ResponseEntity<>(projectService.findProjectById(id), HttpStatus.OK);
    }

    @GetMapping("/allocated")
    public ResponseEntity<List<StudentProjectDto>> getAllAllocatedProjects(){
        return new ResponseEntity<>(projectService.getAllAllocatedProjects(), HttpStatus.OK);
    }
}
