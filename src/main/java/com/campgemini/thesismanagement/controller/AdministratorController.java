package com.campgemini.thesismanagement.controller;

import com.campgemini.thesismanagement.domain.dto.ProjectDto;
import com.campgemini.thesismanagement.domain.dto.TeacherDto;
import com.campgemini.thesismanagement.domain.dto.request.UserAccountDto;
import com.campgemini.thesismanagement.domain.dto.response.MessageResponse;
import com.campgemini.thesismanagement.service.AdministratorService;
import com.campgemini.thesismanagement.service.UserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    AdministratorService administratorService;

    @Autowired
    UserDetailsServiceImplementation userDetailsServiceImplementation;


    @PostMapping("/register")
    public ResponseEntity<?> saveUserAccount(@Valid @RequestBody UserAccountDto userAccountDto){
        if(userDetailsServiceImplementation.checkIfUsernameExist(userAccountDto.getUsername())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }
        System.out.println(userAccountDto.getEmail());
        if(userDetailsServiceImplementation.checkIfEmailExist(userAccountDto.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        return new ResponseEntity<>(administratorService.addUserAccount(userAccountDto), HttpStatus.CREATED);
    }


    @PostMapping("/{idUserAccount}/teachers")
    public ResponseEntity<TeacherDto> saveTeacher(@PathVariable("idUserAccount") int idUserAccount, @Valid @RequestBody TeacherDto teacherDto){
        return new ResponseEntity<>(administratorService.addTeacher(idUserAccount, teacherDto), HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserAccountDto>> getAllUsersAccounts(){
        return new ResponseEntity<>(administratorService.getAllUsersAccounts(), HttpStatus.OK);
    }

    @PostMapping("/{idUserAccount}/role/teacher")
    public ResponseEntity<UserAccountDto> giveTeacherRoleToUser(@PathVariable("idUserAccount") int idUserAccount){
        return new ResponseEntity<>(administratorService.giveTeacherRoleToUser(idUserAccount), HttpStatus.OK);
    }

    @PostMapping("/{idUserAccount}/role/admin")
    public ResponseEntity<UserAccountDto> giveAdminRoleToUser(@PathVariable("idUserAccount") int idUserAccount){
        return new ResponseEntity<>(administratorService.giveAdminRoleToUser(idUserAccount), HttpStatus.OK);
    }


}
