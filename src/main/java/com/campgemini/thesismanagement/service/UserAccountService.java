package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.Role;
import com.campgemini.thesismanagement.domain.UserAccount;
import com.campgemini.thesismanagement.domain.dto.UserAccountDto;
import com.campgemini.thesismanagement.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserAccountService implements UserDetailsService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findByUsername(username);
        if(userAccount == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(userAccount.getUsername(), userAccount.getPassword(), getAuthority(userAccount));
    }

    private Set<SimpleGrantedAuthority> getAuthority(UserAccount userAccount){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        userAccount.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
    }

    public UserAccount save(UserAccountDto userAccountDto){
        UserAccount newUserAccount = userAccountDto.getUserFromDto(); //sa fac mapper
        newUserAccount.setPassword(bcryptEncoder.encode(userAccountDto.getPassword()));
        Role role = roleService.findByName("USER"); //initial toti au rol user
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        newUserAccount.setRoles(roleSet);
        //System.out.println(newUserAccount.getUsername());
        return userAccountRepository.save(newUserAccount);
    }

}
