package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {
    UserAccount findByUsername(String username);
}
