package com.general.model.dao.login.service;

import com.general.model.dao.login.domain.Account;
import com.general.model.dao.login.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account get(Integer accountSeq) {
        return accountRepository.findOne(accountSeq);
    }

    @Override
    public Account get(String email) {
        return accountRepository.findByEmail(email);
    }

    @Override
    public Account set(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public boolean isAccount(String email, String password) {
        Account account = accountRepository.findByEmailAndPassword(email, password);
        return account != null ? true : false;
    }


}
