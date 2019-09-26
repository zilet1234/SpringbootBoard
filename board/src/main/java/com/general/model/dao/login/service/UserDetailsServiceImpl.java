package com.general.model.dao.login.service;

import com.general.model.dao.login.domain.Account;
import com.general.model.dao.login.domain.Member;
import com.general.model.dao.login.domain.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account;

        try {
            account = accountService.get(username);

            if( account == null) {
                throw new UsernameNotFoundException("사용자 EMail 을 찾을수 없습니다.");
            }
        } catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("사용자 EMail 을 찾을수 없습니다.");
        }

        List<Role> roleList = account.getRoleList();
        Member member = account.getMember();

        account.setRoleList(roleList);
        account.setMember(member);

        return account;
    }

}
