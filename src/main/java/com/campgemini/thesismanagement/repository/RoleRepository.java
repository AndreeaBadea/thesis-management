package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findRoleByRoleName(String roleName);
}
