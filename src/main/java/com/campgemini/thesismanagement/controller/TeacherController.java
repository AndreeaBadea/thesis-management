package com.campgemini.thesismanagement.controller;

import com.campgemini.thesismanagement.domain.dto.ProjectDto;
import com.campgemini.thesismanagement.domain.dto.TeacherDto;
import com.campgemini.thesismanagement.domain.dto.TeacherSkillDto;
import com.campgemini.thesismanagement.domain.dto.response.MessageResponse;
import com.campgemini.thesismanagement.service.TeacherService;
import com.campgemini.thesismanagement.service.TeacherSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private final TeacherService teacherService;

    @Autowired
    private final TeacherSkillService teacherSkillService;


    public TeacherController(TeacherService teacherService, TeacherSkillService teacherSkillService) {
        this.teacherService = teacherService;
        this.teacherSkillService = teacherSkillService;
    }

    @GetMapping()
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        return new ResponseEntity<>(teacherService.findAllTeachers(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable int id) {
//        return new ResponseEntity<>(teacherService.findTeacherById(id), HttpStatus.OK);
//    }

    @PostMapping("/{idUserAccount}")
    public ResponseEntity<TeacherDto> saveTeacher(@PathVariable("idUserAccount") int idUserAccount, @Valid @RequestBody TeacherDto teacherDto){
        return new ResponseEntity<>(teacherService.addTeacher(idUserAccount, teacherDto), HttpStatus.CREATED);
    }

    @PostMapping("/{id}/project")
    public ResponseEntity<ProjectDto> addProject(@PathVariable int id, @RequestBody ProjectDto projectDto){
        return new ResponseEntity<>(teacherService.addTeacherProject(id, projectDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/projects")
    public ResponseEntity<List<ProjectDto>> getAllTeacherProjects(@PathVariable int id){
        return new ResponseEntity<>(teacherService.findAllTeacherProjects(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherByIdUserAccount(@PathVariable("id") int id){
        return new ResponseEntity<>(teacherService.findTeacherByIdUserAccount(id), HttpStatus.OK);
    }


    @PutMapping("/{id}/projects/{idProject}")
    public ResponseEntity<ProjectDto> updateTeacherProjects(@PathVariable("id") int id,
                                                            @PathVariable("idProject") int idProject,
                                                            @RequestBody ProjectDto projectDto
                                                            ){
        return new ResponseEntity<>(teacherService.updateTeacherProject(id, idProject, projectDto), HttpStatus.OK);
    }

    @DeleteMapping("/projects/{idProject}")
    public ResponseEntity<Integer> deleteProject(@PathVariable("idProject") Integer idProject){
        teacherService.deleteTeacherProjectById(idProject);
       return new ResponseEntity<>(idProject, HttpStatus.OK);
    }

    @GetMapping("/{idTeacher}/skills")
    public ResponseEntity<TeacherSkillDto> getTeacherSkills(@PathVariable("idTeacher") int idTeacher){
        return new ResponseEntity<>(teacherSkillService.getTeacherSkillByIdTeacher(idTeacher), HttpStatus.OK);
    }

    @PutMapping("/{idTeacher}/skills/{idTeacherSkill}")
    public ResponseEntity<TeacherSkillDto> updateTeacherSkills(@PathVariable("idTeacher") int idTeacher,
                                                               @RequestBody TeacherSkillDto teacherSkillDto,
                                                               @PathVariable("idTeacherSkill") int idTeacherSkill){
        return new ResponseEntity<>(teacherSkillService.updateTeacherSkillDto(idTeacher, teacherSkillDto, idTeacherSkill ), HttpStatus.OK);
    }


    @GetMapping("/greeting")
    public String getTeacher(){
        return "Welcome!";
    }




}
