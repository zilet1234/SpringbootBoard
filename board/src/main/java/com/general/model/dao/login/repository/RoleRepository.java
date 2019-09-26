package com.general.model.dao.login.repository;

import com.general.model.dao.login.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
