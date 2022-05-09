package com.campgemini.thesismanagement.controller;

import com.campgemini.thesismanagement.domain.dto.ProjectDto;
import com.campgemini.thesismanagement.domain.dto.TeacherDto;
import com.campgemini.thesismanagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private final TeacherService teacherService;


    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping()
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        return new ResponseEntity<>(teacherService.findAllTeachers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable int id) {
        return new ResponseEntity<>(teacherService.findTeacherById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<TeacherDto> saveTeacher(@Valid @RequestBody TeacherDto teacherDto){
        return new ResponseEntity<>(teacherService.addTeacher(teacherDto), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/projects")
    public ResponseEntity<ProjectDto> addProject(@PathVariable int id, @RequestBody ProjectDto projectDto){
        return new ResponseEntity<>(teacherService.addTeacherProject(id, projectDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/project")
    public ResponseEntity<List<ProjectDto>> getAllTeacherProjects(@PathVariable int id){
        return new ResponseEntity<>(teacherService.findAllTeacherProjects(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/projects/{idProject}")
    public ResponseEntity<ProjectDto> updateTeacherProjects(@PathVariable("id") int id,
                                                            @PathVariable("idProject") int idProject,
                                                            @RequestBody ProjectDto projectDto
                                                            ){
        return new ResponseEntity<ProjectDto>(teacherService.updateTeacherProject(id, idProject, projectDto), HttpStatus.OK);
    }



}
