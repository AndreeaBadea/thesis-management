package com.campgemini.thesismanagement.service.mapper;

import com.campgemini.thesismanagement.domain.Student;
import com.campgemini.thesismanagement.domain.UserAccount;
import com.campgemini.thesismanagement.domain.dto.StudentDto;
import com.campgemini.thesismanagement.domain.dto.StudentProjectDto;
import com.campgemini.thesismanagement.repository.UserAccountRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Data
@NoArgsConstructor
public class StudentMapper {

    @Autowired
    public static UserAccountRepository userAccountRepository;

    public static StudentDto studentToStudentDto (Student student){
        StudentDto studentDTO = new StudentDto();
        studentDTO.setIdStudent(student.getIdStudent());
        studentDTO.setIdUserAccount(student.getUserAccount().getIdUserAccount());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setCNP(student.getCNP());
        studentDTO.setFaculty(student.getFaculty());
        studentDTO.setFacultyDomain(student.getFacultyDomain());
        studentDTO.setClassroom(student.getClassroom());
        return studentDTO;
    }

    public static Student studentDtoToStudent(StudentDto studentDto){
        Student student = new Student();
        student.setIdStudent(studentDto.getIdStudent());
        student.setUserAccount(studentDto.getUserAccount());
        student.setIdUserAccount(studentDto.getIdUserAccount());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setCNP(studentDto.getCNP());
        student.setFaculty(studentDto.getFaculty());
        student.setFacultyDomain(studentDto.getFacultyDomain());
        student.setClassroom(studentDto.getClassroom());
        return student;
    }
}

