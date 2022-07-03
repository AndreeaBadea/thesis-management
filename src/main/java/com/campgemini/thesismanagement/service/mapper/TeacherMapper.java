package com.campgemini.thesismanagement.service.mapper;

import com.campgemini.thesismanagement.domain.Teacher;
import com.campgemini.thesismanagement.domain.dto.TeacherDto;

public class TeacherMapper {

    public static TeacherDto teacherToTeacherDto (Teacher teacher){
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setIdTeacher(teacher.getIdTeacher());
        teacherDto.setIdUserAccount(teacher.getIdUserAccount().getIdUserAccount());
        teacherDto.setFirstName(teacher.getFirstName());
        teacherDto.setLastName(teacher.getLastName());
        teacherDto.setCNP(teacher.getCNP());
        teacherDto.setNumberOfStudents(teacher.getNumberOfStudents());
        teacherDto.setProjectsList(teacher.getProjectsList());
        return teacherDto;
    }

    public static Teacher teacherDtoToTeacher(TeacherDto teacherDto){
        Teacher teacher = new Teacher();
        teacher.setIdTeacher(teacherDto.getIdTeacher());
        teacher.setIdUserAccount(teacherDto.getUserAccount());
        teacher.setIdForUserAccount(teacherDto.getIdUserAccount());
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setCNP(teacherDto.getCNP());
        teacher.setNumberOfStudents(teacherDto.getNumberOfStudents());
        teacher.setProjectsList(teacherDto.getProjectsList());
        return teacher;
    }

}
