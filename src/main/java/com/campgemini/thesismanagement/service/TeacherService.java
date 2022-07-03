package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.Project;
import com.campgemini.thesismanagement.domain.Teacher;
import com.campgemini.thesismanagement.domain.UserAccount;
import com.campgemini.thesismanagement.domain.dto.ProjectDto;
import com.campgemini.thesismanagement.domain.dto.TeacherDto;
import com.campgemini.thesismanagement.repository.ProjectRepository;
import com.campgemini.thesismanagement.repository.TeacherRepository;
import com.campgemini.thesismanagement.repository.UserAccountRepository;
import com.campgemini.thesismanagement.service.mapper.ProjectMapper;
import com.campgemini.thesismanagement.service.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private final TeacherRepository teacherRepository;

    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    private final UserAccountRepository userAccountRepository;

    @Autowired
    private final ProjectService projectService;


    public TeacherService(TeacherRepository teacherRepository, ProjectRepository projectRepository, UserAccountRepository userAccountRepository, ProjectService projectService) {
        this.teacherRepository = teacherRepository;
        this.projectRepository = projectRepository;
        this.userAccountRepository = userAccountRepository;
        this.projectService = projectService;
    }

    public List<TeacherDto> findAllTeachers(){
        return teacherRepository.findAll()
                .stream()
                .map(TeacherMapper::teacherToTeacherDto)
                .collect(Collectors.toList());
    }

    public TeacherDto findTeacherById(int id){
        return TeacherMapper.teacherToTeacherDto(teacherRepository.getById(id));
    }

    public TeacherDto addTeacher(Integer idUserAccount, TeacherDto teacherDto){
        teacherDto.setUserAccount(userAccountRepository.getByIdUserAccount(idUserAccount));
        teacherDto.setIdUserAccount(idUserAccount);
        Teacher teacher = teacherRepository.save(TeacherMapper.teacherDtoToTeacher(teacherDto));
        UserAccount userAccount = userAccountRepository.getByIdUserAccount(idUserAccount);
        userAccount.setFirstLoginFlag(0);
        userAccountRepository.save(userAccount);
        Logger.info("Teacher id {} added to database.", teacher.getIdTeacher());
        return TeacherMapper.teacherToTeacherDto(teacher);
    }

    public ProjectDto addTeacherProject(Integer idTeacher, ProjectDto projectDto){
        System.out.println("in metoda addTeacherProject");
        projectDto.setTeacher(teacherRepository.getById(idTeacher));
        projectDto.setIdTeacher(idTeacher);
        Project project = projectRepository.save(ProjectMapper.projectDtoToProject(projectDto));
        Logger.info("Teacher id {} added a new project with id {}.", idTeacher, project.getIdProject());
        return ProjectMapper.projectToProjectDto(project);
    }

    public List<ProjectDto> findAllTeacherProjects(Integer idTeacher){
        Teacher teacher = teacherRepository.getById(idTeacher);
        return teacher.getProjectsList().stream()
                .map(ProjectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

    public ProjectDto updateTeacherProject(Integer idTeacher, Integer idProject, ProjectDto projectDto){
        Project existingProject = projectRepository.getById(idProject);
       // existingProject.setTeacher(projectDto.getTeacher());
        existingProject.setTeacher(teacherRepository.getById(idTeacher));
        existingProject.setStudentProject(projectDto.getStudentProject());
        existingProject.setProjectTitle(projectDto.getProjectTitle());
        existingProject.setProjectDescription(projectDto.getProjectDescription());
        existingProject.setProjectAvailability(projectDto.getProjectAvailability());
        Project newProject = projectRepository.save(existingProject);
        Logger.info("Project id {} updated.", idProject);
        return ProjectMapper.projectToProjectDto(newProject);
    }


    public TeacherDto findTeacherByIdUserAccount(Integer idUserAccount){  // gaseste o solutie mai buna!!
        List<Teacher> teachersList = teacherRepository.findAll();
        for(Teacher teacher : teachersList){
            if(Objects.equals(teacher.getIdUserAccount().getIdUserAccount(), idUserAccount)){
                return TeacherMapper.teacherToTeacherDto(teacher);
            }
        }
        return null;
    }

    public void deleteTeacherProjectById(Integer idProject){
//        Teacher teacher = teacherRepository.getById(idTeacher);
//        teacher.getProjectsList().remove(idProject);
        projectRepository.delete(projectRepository.getById(idProject));
    }


}
