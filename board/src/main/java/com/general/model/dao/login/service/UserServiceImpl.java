package com.general.model.dao.login.service;

import com.general.model.dao.login.domain.User;
import com.general.model.dao.login.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User get(Integer accountSeq) {
        return userRepository.findOne(accountSeq);
    }

    @Override
    public User get(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User set(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean isUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user != null ? true : false;
    }

}
