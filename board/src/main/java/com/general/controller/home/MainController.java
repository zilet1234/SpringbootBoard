package com.general.controller.home;

import com.general.model.dao.login.domain.Member;
import com.general.model.dao.login.service.MemberService;
import com.general.model.dao.table.domain.HouseInfo;
import com.general.model.dao.table.service.HouseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
//@RequestMapping("/home")
public class MainController {

    @Autowired
    MemberService memberService;

    @Autowired
    HouseInfoService houseInfoService;

    @Value("${spring.profiles}")
    private String profile;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/blank")
    public String blank() {
        return "/home/blank";
    }

    @RequestMapping("/main")
    public String main() {
        return "/home/main";
    }

    @RequestMapping("/charts")
    public String charts() {
        return "/home/charts";
    }

    @RequestMapping("/forgot-password")
    public String forgotPassword() {
        return "/home/forgot-password";
    }

    @RequestMapping("/register")
    public String register() {
        return "/home/register";
    }

    @RequestMapping("/tables")
    public String tables(Model model) {
        List<Member> memberList = memberService.getAll();
        model.addAttribute("memberList", memberList);
        return "/home/tables";
    }

    @RequestMapping("/tables-houseInfo")
    public String tables_houseInfo(Model model) {
        log.debug(" controller read -> tables-houseInfo ");
        List<HouseInfo> houseInfoList = houseInfoService.getAll();
        model.addAttribute("houseInfoList", houseInfoList);
        return "/home/tables-houseInfo";
    }

    // 기본 쓰기판
    @RequestMapping("/content/basicWrite")
    public String basicWrite(HttpServletRequest request, Model model) {
        model.addAttribute("title", "기본 쓰기");
        model.addAttribute("subject", "제목 작성중 ... ");
        model.addAttribute("content", " 기본내용을 가져오는중 ..... ");
        return "/content/basicWrite";
    }

    @RequestMapping(value = "/sample/test", method = RequestMethod.GET)
    public Map<String, Object> sampleTest(@RequestParam String first, @RequestParam Integer second) {
        Map<String, Object> map = new HashMap<>();
        map.put("first", first);
        map.put("second", second);
        return map;
    }

}
