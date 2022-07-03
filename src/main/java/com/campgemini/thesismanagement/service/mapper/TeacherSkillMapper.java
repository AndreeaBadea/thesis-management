package com.campgemini.thesismanagement.service.mapper;

import com.campgemini.thesismanagement.domain.TeacherSkill;
import com.campgemini.thesismanagement.domain.dto.TeacherSkillDto;

public class TeacherSkillMapper {

    public static TeacherSkillDto teacherSkillToTeacherSkillDto(TeacherSkill teacherSkill){
        TeacherSkillDto teacherSkillDto = new TeacherSkillDto();
        teacherSkillDto.setIdTeachersSkills(teacherSkill.getIdTeachersSkills());
        teacherSkillDto.setIdTeacher(teacherSkill.getIdTeacher().getIdTeacher());
        teacherSkillDto.setSkillsName(teacherSkill.getSkillsName());
        teacherSkillDto.setTeachingSubjects(teacherSkill.getTeachingSubjects());
        return teacherSkillDto;
    }

    public static TeacherSkill teacherSkillDtoToTeacherSkill(TeacherSkillDto teacherSkillDto){
        TeacherSkill teacherSkill = new TeacherSkill();
        teacherSkill.setIdTeachersSkills(teacherSkillDto.getIdTeachersSkills());
        teacherSkill.setIdTeacher(teacherSkill.getIdTeacher());
        teacherSkill.setSkillsName(teacherSkillDto.getSkillsName());
        teacherSkill.setTeachingSubjects(teacherSkillDto.getTeachingSubjects());
        return teacherSkill;
    }


}
