package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Integer> {

    Optional<UserAccount> findByUsername(String username);

    UserAccount getByIdUserAccount(Integer idUserAccount);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


}
