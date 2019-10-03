package com.test.database;

import com.general.model.dao.login.domain.Member;
import com.general.model.dao.login.domain.Role;
import com.general.model.dao.login.domain.User;
import com.general.model.dao.login.service.UserService;
import com.test.ApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest (classes = {ApplicationTests.class})
@ActiveProfiles("young")
public class DatabaseTests {

    @Resource
    UserService userService;

    @Test
    public void test(){
        String email = "zilet1234@naver.com";
        User user = userService.get(email);

        List<Role> roleList = user.getRoleList();

        log.debug("=================================================");
        for (Role role : roleList) {
            log.debug("role name = {}", role.getName());
        }
        log.debug("=================================================");

        Member member = user.getMember();
        log.debug("member name = {}", member.getName());
        log.debug("=================================================");

    }

}
