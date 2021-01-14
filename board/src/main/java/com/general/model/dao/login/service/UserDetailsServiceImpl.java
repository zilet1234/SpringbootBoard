package com.general.model.dao.login.service;

import com.general.model.dao.login.domain.Member;
import com.general.model.dao.login.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user;

        try {
            user = userService.get(username);

            if( user == null) {
                throw new UsernameNotFoundException("사용자 EMail 을 찾을수 없습니다.");
            }
        } catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("사용자 EMail 을 찾을수 없습니다.");
        }

        Member member = user.getMember();
        user.setMember(member);

        return user;
    }

}
