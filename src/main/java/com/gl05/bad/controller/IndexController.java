package com.gl05.bad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String prueba() {
        return "welcome";
    }
    @GetMapping("/welcome2")
    public String pagina2() {
        return "welcome2";
    }
}
