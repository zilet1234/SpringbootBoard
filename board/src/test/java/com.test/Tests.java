package com.test;

import com.general.model.dao.login.domain.Member;
import com.general.model.dao.login.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = TestController.class)
@ActiveProfiles("young")
public class Tests {

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void test(){
        Member member = memberRepository.findOne(1);
        if(member != null) {
            System.out.println(member.getName());
        }
    }

    @Test
    public void test2(){
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", "node -v");
        try {
            Process process = processBuilder.start();

            StringBuilder stringBuilder = new StringBuilder();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = "";

            while ( (line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

//            if (process.waitFor() == 0) {
                System.out.println(stringBuilder.toString());
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
