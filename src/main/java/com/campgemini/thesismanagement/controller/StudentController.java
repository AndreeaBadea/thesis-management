package com.campgemini.thesismanagement.controller;

import com.campgemini.thesismanagement.domain.dto.*;
import com.campgemini.thesismanagement.service.StudentService;
import com.campgemini.thesismanagement.service.StudentSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    @Autowired
    private final StudentSkillService studentSkillService;


    public StudentController(StudentService studentService, StudentSkillService studentSkillService) {
        this.studentService = studentService;
        this.studentSkillService = studentSkillService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<StudentDto> getStudentById(@PathVariable int id) {
//        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getTeacherByIdUserAccount(@PathVariable("id") int id){
        return new ResponseEntity<>(studentService.findStudentByIdUserAccount(id), HttpStatus.OK);
    }

    @PostMapping("/{idUserAccount}")
    public ResponseEntity<StudentDto> saveStudent(@PathVariable("idUserAccount") int idUserAccount, @Valid @RequestBody StudentDto studentDto){
        return new ResponseEntity<>(studentService.addStudent(idUserAccount, studentDto), HttpStatus.CREATED);
    }

    @PostMapping("/{idStudent}/projects/{idProject}")
    public ResponseEntity<StudentProjectDto> requestProject(@PathVariable("idStudent") int idStudent,
                                                            @PathVariable("idProject") int idProject
                                                            ){
        return new ResponseEntity<>(studentService.requestProject(idStudent, idProject), HttpStatus.CREATED);
    }

    @GetMapping("/{idStudent}/skills")
    public ResponseEntity<StudentSkillDto> getStudentSkills(@PathVariable("idStudent") int idStudent){
        return new ResponseEntity<>(studentSkillService.getStudentSkillByIdStudent(idStudent), HttpStatus.OK);
    }

    @PutMapping("/{idStudent}/skills/{idStudentSkill}")
    public ResponseEntity<StudentSkillDto> updateStudentSkills(@PathVariable("idStudent") int idStudent,
                                                               @RequestBody StudentSkillDto studentSkillDto,
                                                               @PathVariable("idStudentSkill") int idStudentSkill){
        return new ResponseEntity<>(studentSkillService.updateStudentSkillDto(idStudent, studentSkillDto, idStudentSkill), HttpStatus.OK);
    }

    @PostMapping("/{idStudent}/projects/request")
    public ResponseEntity<ProjectRequestDto> makeProjectRequest(@PathVariable("idStudent") int idStudent,
                                                                @RequestBody ProjectDto projectDto){
        return new ResponseEntity<ProjectRequestDto>(studentService.makeProjectRequest(idStudent, projectDto), HttpStatus.CREATED);

    }






}
