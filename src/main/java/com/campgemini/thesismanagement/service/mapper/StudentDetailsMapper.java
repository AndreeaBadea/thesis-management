package com.campgemini.thesismanagement.service.mapper;

import com.campgemini.thesismanagement.domain.Student;
import com.campgemini.thesismanagement.domain.StudentDetailsDto;
import com.campgemini.thesismanagement.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDetailsMapper {

    @Autowired
    public static UserAccountRepository userAccountRepository;


    public static StudentDetailsDto studentToStudentDetailsDto (Student student){
        StudentDetailsDto studentDetailsDto = new StudentDetailsDto();
        studentDetailsDto.setIdStudent(student.getIdStudent());
        studentDetailsDto.setIdUserAccount(student.getUserAccount().getIdUserAccount());
        studentDetailsDto.setFirstName(student.getFirstName());
        studentDetailsDto.setLastName(student.getLastName());
        studentDetailsDto.setEmail(student.getUserAccount().getEmail());
        studentDetailsDto.setFaculty(student.getFaculty());
        studentDetailsDto.setFacultyDomain(student.getFacultyDomain());
        studentDetailsDto.setClassroom(student.getClassroom());
        return studentDetailsDto;
    }

    public static Student studentDtoToStudent(StudentDetailsDto studentDetailsDto){
        Student student = new Student();
        student.setIdStudent(studentDetailsDto.getIdStudent());
        student.setUserAccount(studentDetailsDto.getUserAccount());
        student.setIdUserAccount(studentDetailsDto.getIdUserAccount());
        student.setFirstName(studentDetailsDto.getFirstName());
        student.setLastName(studentDetailsDto.getLastName());
        student.setEmail(studentDetailsDto.getEmail());
        student.setFaculty(studentDetailsDto.getFaculty());
        student.setFacultyDomain(student.getFacultyDomain());
        student.setClassroom(student.getClassroom());
        return student;
    }
}
