package com.general.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@Component
public class SampleAuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        log.debug( " ====================> onAuthenticationSuccess .... ");

        HttpSession session = request.getSession();

        if ( session != null){
            String redirectUrl = (String) session.getAttribute("prevPage");

            log.debug( "redirectUrl = {}", redirectUrl);

            if(redirectUrl != null) {
                session.removeAttribute("prevPage");
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
            } else {
                // default targetUrl 로 이동하지 않도록 설정
                super.setAlwaysUseDefaultTargetUrl(true);

                // default 페이지 설정
                super.setDefaultTargetUrl("/main");

                // 페이지 이동
                super.onAuthenticationSuccess(request, response, authentication);
            }
        } else {

            // default targetUrl 로 이동하지 않도록 설정
            super.setAlwaysUseDefaultTargetUrl(true);

            // default 페이지 설정
            super.setDefaultTargetUrl("/main");

            // 페이지 이동
            super.onAuthenticationSuccess(request, response, authentication);

        }



        // targetUrl 파라메터 이름 설정
//        super.setTargetUrlParameter("redirectUrl");


    }

}
