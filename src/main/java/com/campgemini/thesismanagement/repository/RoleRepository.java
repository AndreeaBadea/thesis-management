package com.campgemini.thesismanagement.repository;

import com.campgemini.thesismanagement.domain.EnumRole;
import com.campgemini.thesismanagement.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByRoleName(EnumRole roleName);
}
