package com.general.security.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SampleAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        // 페이지 이동
        request.setAttribute("errMessage", exception.getMessage());
//        request.setAttribute("securedId", request.getParameter("securedId"));
//        request.setAttribute("redirectUrl", request.getParameter("redirectUrl"));

//        request.getRequestDispatcher("/login").forward(request, response);
    }

}
