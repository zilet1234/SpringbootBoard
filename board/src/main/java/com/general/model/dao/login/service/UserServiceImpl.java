package com.general.model.dao.login.service;

import com.general.model.dao.login.domain.Member;
import com.general.model.dao.login.domain.User;
import com.general.model.dao.login.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MemberService memberService;

    @Override
    public User get(Integer accountSeq) {
        return userRepository.findOne(accountSeq);
    }

    @Override
    public User get(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User addByTest(User user) throws Exception {

        try {
            user = userRepository.save(user);

            Member member = user.getMember();

            if(member == null) {
                throw new Exception(" member error !! ");
            }
            memberService.add(member);

        } catch (Exception e){
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }



        return user;
    }


    @Override
    public boolean isUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        return user != null ? true : false;
    }

}
