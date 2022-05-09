package com.campgemini.thesismanagement.service.mapper;

import com.campgemini.thesismanagement.domain.StudentProject;
import com.campgemini.thesismanagement.domain.dto.StudentProjectDto;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentProjectMapper {


    public static StudentProjectDto toStudentProjectDto(StudentProject studentProject){
        StudentProjectDto studentProjectDto = new StudentProjectDto();
        studentProjectDto.setIdStudentProject(studentProject.getIdStudentProject());
        studentProjectDto.setIdStudent(studentProject.getStudent().getIdStudent());
        studentProjectDto.setIdProject(studentProject.getProject().getIdProject());
        return studentProjectDto;
    }


    public static StudentProject toStudentProject(StudentProjectDto studentProjectDto){
        StudentProject studentProject = new StudentProject();
        studentProject.setIdStudentProject(studentProject.getIdStudentProject());
        studentProject.setStudent(studentProjectDto.getStudent());
        studentProject.setProject(studentProjectDto.getProject());
        return studentProject;
    }
}
