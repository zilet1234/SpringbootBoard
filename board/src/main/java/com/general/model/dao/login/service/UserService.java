package com.general.model.dao.login.service;

import com.general.model.dao.login.domain.User;

public interface UserService {

    User get(Integer accountSeq);

    User get(String email);

    User set(User user);

    boolean isUser(String email, String password);

}
