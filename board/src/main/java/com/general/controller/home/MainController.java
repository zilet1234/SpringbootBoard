package com.general.controller.home;

import com.general.model.dao.login.domain.Member;
import com.general.model.dao.login.domain.User;
import com.general.model.dao.login.enums.Role;
import com.general.model.dao.login.service.MemberService;
import com.general.model.dao.login.service.UserService;
import com.general.model.dao.table.domain.HouseInfo;
import com.general.model.dao.table.service.HouseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    UserService userService;

    @Value("${spring.profiles}")
    private String profile;

    @Value("${server.port}")
    private String port;

//    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.POST})
//    public String common(Model model, HttpServletRequest request) {
//        System.out.println("request.getServletPath().substring(1) = " + request.getServletPath().substring(1));
//        return request.getServletPath().substring(1);
//    }

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

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register() {
        return "/home/register";
    }

    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    @ResponseBody
    public Object register(@RequestBody User user){
        user.setRole(Role.USER);
        return userService.add(user);
    }

    @RequestMapping("/tables")
    public String tables(Model model, HttpServletRequest request) {
        List<Member> memberList = memberService.getAll();
        model.addAttribute("memberList", memberList);
        return "/home/tables";
    }

    @RequestMapping("/tables-houseInfo")
    public String tables_houseInfo(Model model) throws Exception {
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

    @ExceptionHandler(Exception.class)
    public String exception(Model model) {
        model.addAttribute("msg", "오류 메세지 !!");
        return "/error/404";
    }
}
