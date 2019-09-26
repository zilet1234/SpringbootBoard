package com.general.controller.sample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sample/bootstrap/")
public class Bootstrap {

    //
    @RequestMapping("/theme")
    public String theme(Model model) {
        return "/sample/theme";
    }

    //
    @RequestMapping("grid")
    public String gird(Model model) {
        return "/sample/grid";
    }

    @RequestMapping("dashboard")
    public String dashboard() {
        return "/sample/dashboard";
    }
}
