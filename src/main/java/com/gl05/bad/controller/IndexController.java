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
    
      @GetMapping("/welcome3")
    public String pagina3(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "welcome3";
    }
    
      @GetMapping("/errorpage")
    public String error(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "errorPage";
    }
    
    @GetMapping("/usuariobloqueado")
    public String correctDisable(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "usuariobloqueado";
    }
    
    @GetMapping("/usuarioinhabilitado")
    public String usernothabilitate(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "usuarioinhabilitado";
    }
    
    @GetMapping("/usuariodeshabilitadobloqueado")
    public String usernothabilitateblocked(Model model) {
        model.addAttribute("pageTitle", "welcome2");
        return "usuariobloqdes";
    }
    
}
