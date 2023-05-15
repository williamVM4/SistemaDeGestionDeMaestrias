package com.gl05.bad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String prueba(Model model) {
        model.addAttribute("pageTitle", "Welcome");
        return "welcome";
    }
    @GetMapping("/welcome2")
    public String pagina2(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "welcome2";
    }
    
}
