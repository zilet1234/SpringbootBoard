package com.general.security.providor;

import com.general.model.dao.login.domain.User;
import com.general.model.dao.login.service.UserService;
import com.general.model.dao.login.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = (String) authentication.getCredentials();

        log.debug("1. info - email = {} :: password = {}", email, password);

        User user = (User) userDetailsServiceImpl.loadUserByUsername(email);

        if( user == null || !user.isEnabled()) {
            log.debug("2. info - email = {} :: password = {}", email, password);
            throw new UsernameNotFoundException("사용자의 Email 주소를 찾을수 없습니다.");
        }

        if ( !userService.isUser(email, password)) {
            log.debug("3. email = {} :: password = {}", email, password);
            throw new BadCredentialsException("Email 주소가 잘못 되었거나 패스워드가 맞지 않습니다.");
        }

        log.debug("4. email = {} :: password = {}", email, password);

        // 권한 정보
        Collection< ? extends GrantedAuthority> authorities = user.getAuthorities();

        while (authorities.iterator().hasNext()) {
            log.debug("authorities = {}", authorities.iterator().next().getAuthority());
        }

        return new UsernamePasswordAuthenticationToken(email, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
