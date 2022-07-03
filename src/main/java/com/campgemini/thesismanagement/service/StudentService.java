package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.Student;
import com.campgemini.thesismanagement.domain.StudentDetailsDto;
import com.campgemini.thesismanagement.domain.StudentProject;
import com.campgemini.thesismanagement.domain.UserAccount;
import com.campgemini.thesismanagement.domain.dto.StudentDto;
import com.campgemini.thesismanagement.domain.dto.StudentProjectDto;
import com.campgemini.thesismanagement.repository.ProjectRepository;
import com.campgemini.thesismanagement.repository.StudentProjectRepository;
import com.campgemini.thesismanagement.repository.StudentRepository;
import com.campgemini.thesismanagement.repository.UserAccountRepository;
import com.campgemini.thesismanagement.service.mapper.StudentMapper;
import com.campgemini.thesismanagement.service.mapper.StudentProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public StudentService(StudentRepository studentRepository, ProjectRepository projectRepository, StudentProjectRepository studentProjectRepository, UserAccountRepository userAccountRepository, ProjectService projectService) {
        this.studentRepository = studentRepository;
        this.projectRepository = projectRepository;
        this.studentProjectRepository = studentProjectRepository;
        this.userAccountRepository = userAccountRepository;
        this.projectService = projectService;
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

//    public List<StudentDetailsDto> findAllStudentsDetails(){
//      //  StudentDetailsDto studentDetailsDto = new StudentDetailsDto();
//        return studentProjectRepository.findAll()
//                .stream()
//                .map(StudentProjectMapper::studentToStudentDetailsDto)
//                .collect(Collectors.toList());
//
//        findAllStudentsDetails()
//
//    }



    public boolean checkThesisStatus(Integer idStudent){
        Optional<StudentProject> currentStudent = studentProjectRepository.findById(idStudent);
        if(currentStudent.isPresent()){
            return true;
        }
        return false;
        }
    }



