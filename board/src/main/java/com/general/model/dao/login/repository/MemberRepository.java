package com.general.model.dao.login.repository;

import com.general.model.dao.login.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
