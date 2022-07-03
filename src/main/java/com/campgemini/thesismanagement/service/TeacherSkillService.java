package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.Teacher;
import com.campgemini.thesismanagement.domain.TeacherSkill;
import com.campgemini.thesismanagement.domain.dto.TeacherSkillDto;
import com.campgemini.thesismanagement.repository.TeacherRepository;
import com.campgemini.thesismanagement.repository.TeacherSkillRepository;
import com.campgemini.thesismanagement.service.mapper.TeacherMapper;
import com.campgemini.thesismanagement.service.mapper.TeacherSkillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeacherSkillService {

    @Autowired
    private TeacherSkillRepository teacherSkillRepository;

    @Autowired
    private TeacherRepository teacherRepository;


    public TeacherSkillDto getTeacherSkillByIdTeacher(Integer idTeacher) {
        List<TeacherSkill> teacherSkillList = teacherSkillRepository.findAll();
        for(TeacherSkill teacherSkill : teacherSkillList){
            if(Objects.equals(idTeacher, teacherSkill.getIdTeacher().getIdTeacher())){
                return TeacherSkillMapper.teacherSkillToTeacherSkillDto(teacherSkill);
            }
        }
        return null;
    }

    public TeacherSkillDto updateTeacherSkillDto(Integer idTeacher, TeacherSkillDto teacherSkillDto, Integer idTeacherSkill){
        TeacherSkill existingTeacherSkill = teacherSkillRepository.getById(idTeacherSkill);
        existingTeacherSkill.setIdTeacher(teacherRepository.getById(idTeacher));
        existingTeacherSkill.setSkillsName(teacherSkillDto.getSkillsName());
        existingTeacherSkill.setTeachingSubjects(teacherSkillDto.getTeachingSubjects());
        System.out.println("updateTeacherSkillDto" + existingTeacherSkill.getTeachingSubjects());
        TeacherSkill newTeacherSkill = teacherSkillRepository.save(existingTeacherSkill);
        Logger.info("Teacher skill id {} updated.", idTeacherSkill);
        return TeacherSkillMapper.teacherSkillToTeacherSkillDto(newTeacherSkill);
    }
}
