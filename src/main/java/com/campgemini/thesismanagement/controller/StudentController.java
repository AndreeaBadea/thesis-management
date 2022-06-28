package com.campgemini.thesismanagement.controller;

import com.campgemini.thesismanagement.domain.dto.StudentDto;
import com.campgemini.thesismanagement.domain.dto.StudentProjectDto;
import com.campgemini.thesismanagement.service.StudentService;
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


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable int id) {
        return new ResponseEntity<>(studentService.findStudentById(id), HttpStatus.OK);
    }

    @PostMapping("/{idUserAccount}")
    public ResponseEntity<StudentDto> saveStudent(@PathVariable("idUserAccount") int idUserAccount, @Valid @RequestBody StudentDto studentDto){
        System.out.println(studentDto.getCNP());
        System.out.println(studentDto.getFirstName());
        System.out.println(studentDto.getLastName());
        return new ResponseEntity<>(studentService.addStudent(idUserAccount, studentDto), HttpStatus.CREATED);
    }

    @PostMapping("/{idStudent}/projects/{idProject}")
    public ResponseEntity<StudentProjectDto> requestProject(@PathVariable("idStudent") int idStudent,
                                                            @PathVariable("idProject") int idProject
                                                            ){
        return new ResponseEntity<>(studentService.requestProject(idStudent, idProject), HttpStatus.OK);
    }




}
