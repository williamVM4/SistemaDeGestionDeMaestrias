package com.gl05.bad.controller;

import com.gl05.bad.servicio.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Asignatura {
    @Autowired
    private AsignaturaService asignaturaService;
}
