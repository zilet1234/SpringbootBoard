package com.general.security;

import com.general.model.dao.login.service.UserDetailsServiceImpl;
import com.general.security.handler.SampleAuthFailureHandler;
import com.general.security.handler.SampleAuthLogoutSuccessHandler;
import com.general.security.handler.SampleAuthSuccessHandler;
import com.general.security.providor.UserAuthenticationProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author 곽우영
 * @since 2019-03-30
 */
@Slf4j
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserAuthenticationProvider userAuthenticationProvider;

	@Autowired
	SampleAuthSuccessHandler sampleAuthSuccessHandler;

	@Autowired
	SampleAuthFailureHandler sampleAuthFailureHandler;

	@Autowired
	SampleAuthLogoutSuccessHandler sampleAuthLogoutSuccessHandler;

    @Autowired
	UserDetailsServiceImpl userDetailsServiceImpl;

	@Override
	public void configure(AuthenticationManagerBuilder builder) {
		log.info("configure :: AuthenticationManagerBuilder ");
		builder.authenticationProvider(userAuthenticationProvider);
	}

	@Override
	public void configure(WebSecurity webSecurity) {
		log.info("configure :: WebSecurity ");
		webSecurity.ignoring().antMatchers("/resources/**");
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
			log.info("configure :: HttpSecurity ");
			httpSecurity.csrf().disable();

			httpSecurity.authorizeRequests()
					.antMatchers("/login").permitAll()
					.antMatchers("/**")
					.authenticated()
                .and()
					.formLogin()
					.loginPage("/login")
					.usernameParameter("email")
					.passwordParameter("password")
                    .loginProcessingUrl("/loginProcess")
//					.defaultSuccessUrl("/main")
					.successHandler(sampleAuthSuccessHandler)
					.failureHandler(sampleAuthFailureHandler)
			    .and()
			    	.logout()
                    .logoutUrl("/logout")
                    .logoutSuccessHandler(sampleAuthLogoutSuccessHandler);
	}

}
