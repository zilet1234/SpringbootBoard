package com.general.controller.login;

import com.general.model.dao.login.service.UserService;
import com.general.model.dao.login.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    MemberService memberService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Model model, HttpServletRequest request) {
//        // 인증 페이지로 이동하기 전 URL 기억
//        String referrer = request.getHeader("Referer");
//        request.getSession().setAttribute("prevPage", referrer);

        return "/login/login";
    }

}
