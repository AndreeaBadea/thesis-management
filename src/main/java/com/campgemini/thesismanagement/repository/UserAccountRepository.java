package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<User, Long> {

}
