package com.general.model.dao.login.repository;

import com.general.model.dao.login.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Account findByEmailAndPassword(String email, String password);
    Account findByEmail(String email);
}
