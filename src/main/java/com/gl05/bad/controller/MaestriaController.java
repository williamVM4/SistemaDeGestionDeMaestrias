package com.gl05.bad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaestriaController {
    
    @GetMapping("/maestria/index")
    public String prueba(Model model) {
        model.addAttribute("pageTitle", "Maestrias");
        return "/maestria/listadoMaestrias";
    }
}
