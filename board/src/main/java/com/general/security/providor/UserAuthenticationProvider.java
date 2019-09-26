package com.general.security.providor;

import com.general.model.dao.login.domain.Account;
import com.general.model.dao.login.service.AccountService;
import com.general.model.dao.login.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    AccountService accountService;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = (String) authentication.getCredentials();

        log.info("1. info - email = {} :: password = {}", email, password);

        Account account = (Account) userDetailsServiceImpl.loadUserByUsername(email);

//        if( account == null || account.isEnabled()) {
        if( account == null) {
            log.info("2. info - email = {} :: password = {}", email, password);
            throw new UsernameNotFoundException("사용자의 Email 주소를 찾을수 없습니다.");
        }

        if ( !accountService.isAccount(email, password)) {
            log.info("3. email = {} :: password = {}", email, password);
            throw new BadCredentialsException("Email 주소가 잘못 되었거나 패스워드가 맞지 않습니다.");
        }

        log.info("4. email = {} :: password = {}", email, password);

        return new UsernamePasswordAuthenticationToken(email, password, authentication.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
