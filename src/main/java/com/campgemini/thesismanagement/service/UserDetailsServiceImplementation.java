package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.EnumRole;
import com.campgemini.thesismanagement.domain.Role;
import com.campgemini.thesismanagement.domain.UserAccount;
import com.campgemini.thesismanagement.domain.dto.request.UserAccountDto;
import com.campgemini.thesismanagement.repository.RoleRepository;
import com.campgemini.thesismanagement.repository.UserAccountRepository;
import com.campgemini.thesismanagement.service.mapper.UserAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.tinylog.Logger;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + "not found."));
        return UserDetailsImplementation.buildUserDetails(userAccount);
    }

    public Boolean checkIfEmailExist(String email){
        if(userAccountRepository.existsByEmail(email)){
            return true;
        }
        return false;
    }

    public Boolean checkIfUsernameExist(String username) {
        if (userAccountRepository.existsByUsername(username)) {
            return true;
        }
        return false;
    }


    public UserAccountDto  addUserAccount(UserAccountDto userAccountDto) {

        UserAccount userAccount = new UserAccount();
        userAccount.setIdUserAccount(userAccountDto.getIdUserAccount());
        userAccount.setUsername(userAccountDto.getUsername());
        userAccount.setEmail(userAccountDto.getEmail());
        userAccount.setPassword(passwordEncoder.encode(userAccountDto.getPassword()));

        Set<String> roleSet = userAccountDto.getRoles();

        Role defaultRole = roleRepository.findByRoleName(EnumRole.ROLE_USER);
        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);
//        if(roleSet == null){
//            Role userRole = roleRepository.findByRoleName(EnumRole.ROLE_USER)
//                    .orElseThrow(() -> new RuntimeException("Could not find role user."));
//        }else {
//            roleSet.forEach(role -> {
//                switch (role) {
//                    case "admin":
//                        Role adminRole = roleRepository.findByRoleName(EnumRole.ROLE_ADMIN)
//                                .orElseThrow(() -> new RuntimeException("Could not find role admin."));
//                        roles.add(adminRole);
//                        break;
//                    case "teacher":
//                        Role teacherRole = roleRepository.findByRoleName(EnumRole.ROLE_TEACHER)
//                                .orElseThrow(() -> new RuntimeException("Could not find role teacher."));
//                        roles.add(teacherRole);
//                        break;
//                    default:
//                        Role userRole = roleRepository.findByRoleName(EnumRole.ROLE_USER)
//                                .orElseThrow(() -> new RuntimeException("Could not find role user."));
//                        roles.add(userRole);
//                }
//            });

        userAccount.setRoles(roles);
        userAccount.setCreatedAt(LocalDateTime.now());
        userAccountRepository.save((userAccount));
        Logger.info("User registered successfully!");
        return UserAccountMapper.userAccountToUserAccountDto(userAccount);
    }



}
