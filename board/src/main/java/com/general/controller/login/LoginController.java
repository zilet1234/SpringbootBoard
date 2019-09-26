package com.general.controller.login;

import com.general.model.dao.login.domain.Account;
import com.general.model.dao.login.domain.Member;
import com.general.model.dao.login.domain.Role;
import com.general.model.dao.login.service.AccountService;
import com.general.model.dao.login.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    AccountService accountService;

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(Model model, HttpServletRequest request) {
        return "/login/login";
    }

}
