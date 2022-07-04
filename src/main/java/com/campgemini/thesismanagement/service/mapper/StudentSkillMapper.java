package com.campgemini.thesismanagement.service.mapper;

import com.campgemini.thesismanagement.domain.StudentSkill;
import com.campgemini.thesismanagement.domain.dto.StudentSkillDto;

public class StudentSkillMapper {


    public static StudentSkillDto studentSkillToStudentSkillDto(StudentSkill studentSkill){
        StudentSkillDto studentSkillDto = new StudentSkillDto();
        studentSkillDto.setIdStudentSkills(studentSkill.getIdStudentSkill());
        studentSkillDto.setIdStudent(studentSkill.getIdStudent().getIdStudent());
        studentSkillDto.setSkillsName(studentSkill.getSkillsName());
        studentSkillDto.setWorkExperience(studentSkill.getWorkExperience());
        return studentSkillDto;
    }

//    public static TeacherSkill teacherSkillDtoToTeacherSkill(StudentSkillDto studentSkillDto){
//        StudentSkill studentSkill = new TeacherSkill();
//        studentSkill.setIdStudentSkill(studentSkillDto.getIdStudentSkills());
//        studentSkill.setIdStudent(studentSkillDto.getIdStudent());
//        studentSkill.setSkillsName(studentSkillDto.getSkillsName());
//        studentSkill.setWorkExperience(studentSkillDto.getTeachingSubjects());
//        return studentSkill;
//    }
}
