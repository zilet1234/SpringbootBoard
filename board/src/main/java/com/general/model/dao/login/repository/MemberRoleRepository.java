package com.general.model.dao.login.repository;

import com.general.model.dao.login.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 곽우영
 * @since 2019-04-08
 */
public interface MemberRoleRepository extends JpaRepository<Role, Integer> {

}
