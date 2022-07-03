package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.EnumRole;
import com.campgemini.thesismanagement.domain.Role;
import com.campgemini.thesismanagement.domain.Teacher;
import com.campgemini.thesismanagement.domain.UserAccount;
import com.campgemini.thesismanagement.domain.dto.TeacherDto;
import com.campgemini.thesismanagement.domain.dto.request.UserAccountDto;
import com.campgemini.thesismanagement.repository.AdministratorRepository;
import com.campgemini.thesismanagement.repository.RoleRepository;
import com.campgemini.thesismanagement.repository.TeacherRepository;
import com.campgemini.thesismanagement.repository.UserAccountRepository;
import com.campgemini.thesismanagement.service.mapper.StudentMapper;
import com.campgemini.thesismanagement.service.mapper.TeacherMapper;
import com.campgemini.thesismanagement.service.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdministratorService {

    @Autowired
    AdministratorRepository administratorRepository;

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherService teacherService;

    @Autowired
    UserDetailsServiceImplementation userDetailsServiceImplementation;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    RoleRepository roleRepository;

    public AdministratorService(TeacherRepository teacherRepository, AdministratorRepository administratorRepository) {
        this.teacherRepository = teacherRepository;
        this.administratorRepository = administratorRepository;
    }


    public TeacherDto addTeacher(Integer idUserAccount, TeacherDto teacherDto){
        return teacherService.addTeacher(idUserAccount, teacherDto);
    }

    public UserAccountDto addUserAccount(UserAccountDto userAccountDto){
        return userDetailsServiceImplementation.addUserAccount(userAccountDto);
    }

    public List<UserAccountDto> getAllUsersAccounts(){
        return userAccountRepository.findAll()
                .stream()
                .map(UserAccountMapper::userAccountToUserAccountDto)
                .collect(Collectors.toList());
    }

    public UserAccountDto giveTeacherRoleToUser(Integer idUserAccount){
       UserAccount userAccount = userAccountRepository.getByIdUserAccount(idUserAccount);
        Set<Role> rolesSet = userAccount.getRoles();
        Role teacherRole = roleRepository.findByRoleName(EnumRole.ROLE_TEACHER);
        rolesSet.add(teacherRole);
        userAccount.setRoles(rolesSet);
        System.out.println("set roles" + rolesSet);
        userAccountRepository.save((userAccount));
        Logger.info("User {idUserAccount} has now ROLE_TEACHER!", idUserAccount);
        return UserAccountMapper.userAccountToUserAccountDto(userAccount);
    }

    public UserAccountDto giveAdminRoleToUser(Integer idUserAccount){
        UserAccount userAccount = userAccountRepository.getByIdUserAccount(idUserAccount);
        Set<Role> rolesSet = userAccount.getRoles();
        Role adminRole = roleRepository.findByRoleName(EnumRole.ROLE_ADMIN);
        rolesSet.add(adminRole);
        userAccount.setRoles(rolesSet);
        userAccountRepository.save((userAccount));
        Logger.info("User {idUserAccount} has now ROLE_ADMIN!", idUserAccount);
        return UserAccountMapper.userAccountToUserAccountDto(userAccount);
    }





}
