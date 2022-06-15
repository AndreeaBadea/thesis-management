package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.EnumRole;
import com.campgemini.thesismanagement.domain.Role;
import com.campgemini.thesismanagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findByName(EnumRole roleName){
       return roleRepository.findByRoleName(roleName);
    }
}
