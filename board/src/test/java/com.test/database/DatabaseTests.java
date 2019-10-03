package com.test.database;

import com.general.model.dao.login.domain.Member;
import com.general.model.dao.login.domain.Role;
import com.general.model.dao.login.domain.User;
import com.general.model.dao.login.repository.MemberRepository;
import com.general.model.dao.login.service.UserService;
import com.test.ApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest (classes = {ApplicationTests.class})
@ActiveProfiles("young")
public class DatabaseTests {

    @Autowired
    UserService userService;

    @Test
    public void test(){
        String email = "zilet1234@naver.com";
        User user = userService.get(email);

        List<Role> roleList = user.getRoleList();

        log.info("=================================================");
        for (Role role : roleList) {
            log.info("role name = {}", role.getName());
        }
        log.info("=================================================");

        Member member = user.getMember();
        log.info("member name = {}", member.getName());
        log.info("=================================================");

    }

}
