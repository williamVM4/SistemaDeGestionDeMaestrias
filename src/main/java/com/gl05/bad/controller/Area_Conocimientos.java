package com.gl05.bad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Area_Conocimientos {
    @GetMapping("/area_conocimiento/index")
    public String pagina3(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "Area_Conocimiento/index";
    }
}
