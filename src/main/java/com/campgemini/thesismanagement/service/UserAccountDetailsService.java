package com.campgemini.thesismanagement.service;

import com.campgemini.thesismanagement.domain.UserAccount;
import com.campgemini.thesismanagement.domain.UserAccountDetails;
import com.campgemini.thesismanagement.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserAccountDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        UserAccount userAccount = userAccountRepository.findUserAccountByUsername(username);
        if(userAccount == null){
            throw new UsernameNotFoundException("Could not find user account.");
        }
        return new UserAccountDetails(userAccount);
    }
}
