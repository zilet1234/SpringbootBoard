package com.test.database;

import com.general.model.dao.login.domain.User;
import com.general.model.dao.login.enums.Role;
import com.general.model.dao.login.service.UserService;
import com.test.ApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest (classes = {ApplicationTests.class})
@ActiveProfiles("home")
public class DatabaseTests {

    @Autowired
    UserService userService;

    @Test
    public void test(){
        User user = new User();

        user.setEmail("test4@naver.com");
        user.setPassword("test4");
        user.setRole(Role.USER);

        try {
            userService.addByTest(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
