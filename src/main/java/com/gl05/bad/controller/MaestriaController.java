package com.gl05.bad.controller;

import com.gl05.bad.dao.MaestriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaestriaController {
    @Autowired
    private MaestriaDao maestriaDao;
    
    @GetMapping("/maestria/index")
    public String prueba(Model model) {
        model.addAttribute("pageTitle", "Maestrias");
        
        var maestrias = maestriaDao.findAll();
        
        model.addAttribute("maestrias", maestrias);
        return "/maestria/index";
    }
}
