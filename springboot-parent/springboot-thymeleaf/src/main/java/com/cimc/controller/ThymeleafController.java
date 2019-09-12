package com.cimc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author chenz
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @RequestMapping(value = "index")
    public String index(Model model) {
        model.addAttribute("msg", "Spring Boot集成Thymeleaf成功！");
        //页面名称
        return "index";
    }
}
