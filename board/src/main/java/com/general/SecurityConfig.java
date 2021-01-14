package com.general;

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

	@Override
	public void configure(AuthenticationManagerBuilder builder) {
		log.info("configure register [AuthenticationManagerBuilder] ");
		builder.authenticationProvider(userAuthenticationProvider);
	}

	@Override
	public void configure(WebSecurity webSecurity) {
		log.info("configure register [WebSecurity]");

		// 지정 디렉토리의 하위 파일 및 디렉토리는 인증 제외
		webSecurity.ignoring().antMatchers("/resources/**");
	}

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
			log.info("configure register [HttpSecurity] ");

			// csrf 사용 불가 설정
			httpSecurity.csrf().disable();

			// X-Frame-Options 사용 불가 설정
			httpSecurity.headers().frameOptions().disable();

			httpSecurity.authorizeRequests()
					// 페이지 권한 설정
					.antMatchers("/sample/test").hasRole("ADMIN")
					.antMatchers("/forgot-password").permitAll()
					.antMatchers("/register").permitAll()
					.antMatchers("/user/register").permitAll()
					.antMatchers("/login").permitAll()
					.antMatchers("/**").authenticated()
                .and()
					.formLogin()
					.loginPage("/login")
					.usernameParameter("email")
					.passwordParameter("password")
                    .loginProcessingUrl("/loginProcess")
					.successHandler(sampleAuthSuccessHandler)
					.failureHandler(sampleAuthFailureHandler)
					.permitAll()
			    .and()
			    	.logout()
                    .logoutUrl("/logout")
                    .logoutSuccessHandler(sampleAuthLogoutSuccessHandler)
//					.deleteCookies("JSESSIONID") // 쿠키 삭제
				.and()
					.exceptionHandling().accessDeniedPage("/404");

	}

}
