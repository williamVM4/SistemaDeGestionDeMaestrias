package com.gl05.bad.controller;

import com.gl05.bad.domain.Maestria;
import com.gl05.bad.servicio.MaestriaService;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MaestriaController {
    @Autowired
    private MaestriaService maestriaService;
    
    @GetMapping("/maestria/index")
    public String listarMaestrias(Model model) {
        return "maestria/index";
    }
    
    @GetMapping("/maestria/data")
    @ResponseBody
    public DataTablesOutput<Maestria> getMaestrias(@Valid DataTablesInput input) {
      return maestriaService.listarMaestrias(input);
    }
    
}
