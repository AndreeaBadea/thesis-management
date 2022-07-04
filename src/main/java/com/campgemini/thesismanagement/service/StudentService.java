package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.ProjectRequest;
import com.campgemini.thesismanagement.domain.Student;
import com.campgemini.thesismanagement.domain.StudentProject;
import com.campgemini.thesismanagement.domain.UserAccount;
import com.campgemini.thesismanagement.domain.dto.ProjectDto;
import com.campgemini.thesismanagement.domain.dto.ProjectRequestDto;
import com.campgemini.thesismanagement.domain.dto.StudentDto;
import com.campgemini.thesismanagement.domain.dto.StudentProjectDto;
import com.campgemini.thesismanagement.repository.*;
import com.campgemini.thesismanagement.service.mapper.ProjectRequestMapper;
import com.campgemini.thesismanagement.service.mapper.StudentMapper;
import com.campgemini.thesismanagement.service.mapper.StudentProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private final StudentRepository studentRepository;

    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    private final StudentProjectRepository studentProjectRepository;

    @Autowired
    private final UserAccountRepository userAccountRepository;

    @Autowired
    private final ProjectService projectService;

    @Autowired
    private final ProjectRequestRepository projectRequestRepository;

    public StudentService(StudentRepository studentRepository, ProjectRepository projectRepository, StudentProjectRepository studentProjectRepository, UserAccountRepository userAccountRepository, ProjectService projectService, ProjectRequestRepository projectRequestRepository) {
        this.studentRepository = studentRepository;
        this.projectRepository = projectRepository;
        this.studentProjectRepository = studentProjectRepository;
        this.userAccountRepository = userAccountRepository;
        this.projectService = projectService;
        this.projectRequestRepository = projectRequestRepository;
    }

    public List<StudentDto> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentMapper::studentToStudentDto)
                .collect(Collectors.toList());
    }

    public StudentDto findStudentById(int id){
        return StudentMapper.studentToStudentDto(studentRepository.getById(id));
    }

    public StudentDto addStudent(Integer idUserAccount, StudentDto studentDto){
        studentDto.setUserAccount(userAccountRepository.getByIdUserAccount(idUserAccount));
        studentDto.setIdUserAccount(idUserAccount);
        Student student = studentRepository.save(StudentMapper.studentDtoToStudent(studentDto));
        UserAccount userAccount = userAccountRepository.getByIdUserAccount(idUserAccount);
        userAccount.setFirstLoginFlag(0);
        userAccountRepository.save(userAccount); 
        return StudentMapper.studentToStudentDto(student);
    }

    public StudentProjectDto requestProject(int idStudent, int idProject){
        StudentProjectDto studentProjectDto = new StudentProjectDto();
        studentProjectDto.setIdStudent(idStudent);
        studentProjectDto.setStudent(studentRepository.getById(idStudent));
        studentProjectDto.setProject(projectRepository.getById(idProject));
        studentProjectDto.setIdProject(idProject);
        StudentProject studentProject = studentProjectRepository.save(StudentProjectMapper.toStudentProject(studentProjectDto));
        return StudentProjectMapper.toStudentProjectDto(studentProject);
    }

    public boolean checkThesisStatus(Integer idStudent){
        Optional<StudentProject> currentStudent = studentProjectRepository.findById(idStudent);
        if(currentStudent.isPresent()){
            return true;
        }
        return false;
        }

    public StudentDto findStudentByIdUserAccount(Integer idUserAccount){
        List<Student> studentsList = studentRepository.findAll();
        for(Student student: studentsList){
            if(Objects.equals(student.getUserAccount().getIdUserAccount(), idUserAccount)){
                return StudentMapper.studentToStudentDto(student);
            }
        }
        return null;
    }

    public ProjectRequestDto makeProjectRequest(Integer idStudent, ProjectDto projectDto){
        ProjectRequestDto projectRequestDto = new ProjectRequestDto();
        projectRequestDto.setIdStudent(idStudent);
        projectRequestDto.setStudent(studentRepository.getById(idStudent));
        projectRequestDto.setProject(projectRepository.getById(projectDto.getIdProject()));
        ProjectRequest projectRequest = projectRequestRepository.save((ProjectRequestMapper.projectRequestDtoToProjectRequest(projectRequestDto)));
        return ProjectRequestMapper.projectRequestToProjectRequestDto(projectRequest);

    }


//    public StudentProjectDto requestProject(int idStudent, int idProject){
//        StudentProjectDto studentProjectDto = new StudentProjectDto();
//        studentProjectDto.setIdStudent(idStudent);
//        studentProjectDto.setStudent(studentRepository.getById(idStudent));
//        studentProjectDto.setProject(projectRepository.getById(idProject));
//        studentProjectDto.setIdProject(idProject);
//        StudentProject studentProject = studentProjectRepository.save(StudentProjectMapper.toStudentProject(studentProjectDto));
//        return StudentProjectMapper.toStudentProjectDto(studentProject);
//    }
    }



