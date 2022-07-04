package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.StudentSkill;
import com.campgemini.thesismanagement.domain.dto.StudentSkillDto;
import com.campgemini.thesismanagement.repository.StudentRepository;
import com.campgemini.thesismanagement.repository.StudentSkillRepository;
import com.campgemini.thesismanagement.service.mapper.StudentSkillMapper;
import com.campgemini.thesismanagement.service.mapper.TeacherSkillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.util.List;
import java.util.Objects;

@Service
public class StudentSkillService {

    @Autowired
    private StudentSkillRepository studentSkillRepository;

    @Autowired
    private StudentRepository studentRepository;

    public StudentSkillDto getStudentSkillByIdStudent(Integer idStudent) {
        List<StudentSkill> studentSkillList = studentSkillRepository.findAll();
        for (StudentSkill studentSkill : studentSkillList) {
            if (Objects.equals(idStudent, studentSkill.getIdStudent().getIdStudent())) {
                System.out.println("getItStudentSkill" + studentSkill.getIdStudentSkill());
                System.out.println("getWorkExperience" + studentSkill.getWorkExperience());
                StudentSkillDto studentSkillDto = StudentSkillMapper.studentSkillToStudentSkillDto(studentSkill);
                System.out.println("getItStudentSkill" + studentSkillDto.getIdStudentSkills());
                System.out.println("getWorkExperience" + studentSkillDto.getWorkExperience());
                return studentSkillDto;
            }
        }
        return null;
    }

    public StudentSkillDto updateStudentSkillDto(Integer idStudent, StudentSkillDto studentSkillDto, Integer idStudentSkill) {
        StudentSkill existingStudentSkill = studentSkillRepository.getById(idStudentSkill);
        existingStudentSkill.setIdStudent(studentRepository.getById(idStudent));
        existingStudentSkill.setSkillsName(studentSkillDto.getSkillsName());
        existingStudentSkill.setWorkExperience(studentSkillDto.getWorkExperience());
        System.out.println("Work Experiencee!!" + existingStudentSkill.getWorkExperience());
        StudentSkill newStudentSkill = studentSkillRepository.save(existingStudentSkill);
        Logger.info("Student skill id {} updated.", idStudentSkill);
        return StudentSkillMapper.studentSkillToStudentSkillDto(newStudentSkill);
    }
}
