package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    UserAccount findUserAccountByUsername(String username);


}
