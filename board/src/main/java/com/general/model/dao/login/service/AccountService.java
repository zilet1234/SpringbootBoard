package com.general.model.dao.login.service;

import com.general.model.dao.login.domain.Account;

public interface AccountService {

    Account get(Integer accountSeq);

    Account get(String email);

    Account set(Account account);

    boolean isAccount(String email, String password);

}
