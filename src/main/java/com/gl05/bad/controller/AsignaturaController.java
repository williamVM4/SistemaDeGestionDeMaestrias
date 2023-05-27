package com.gl05.bad.controller;

import com.gl05.bad.domain.Asignatura;
import com.gl05.bad.servicio.AreaConocimientoService;
import com.gl05.bad.servicio.AsignaturaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private AreaConocimientoService areaConocimientoService;

    @GetMapping("/Asignaturas/{idPlanEstudio}")
    public String Asignatura(Model model, Asignatura asignatura, RedirectAttributes redirectAttributes) {
        var areaC = areaConocimientoService.listarAreaConocimientos();
        model.addAttribute("areaC", areaC);
        return "Asignatura/index";
    }

    @GetMapping("/Asignatura/data")
    @ResponseBody
    public DataTablesOutput<Asignatura> getAsignatura(@Valid DataTablesInput input) {
        System.out.println(asignaturaService.listarAsignatura(input));
        return asignaturaService.listarAsignatura(input);
    }

    @PostMapping("/AgregarAsignatura")
    public ResponseEntity<String> AgregarAsignatura(
            @RequestParam("codigoAsignatura") String codigoAsignatura,
            @RequestParam("nombreAsignatura") String nombreAsignatura,
            @RequestParam("uv") int uv,
            @RequestParam("numeroCorrelativo") int numeroCorrelativo,
            @RequestParam("ciclo") int ciclo,
            @RequestParam("idAreaC") long idAreaC,
            @RequestParam("idMalla") long idMalla,
            @RequestParam("duracion") int duracion,
            @RequestParam("horasT") int horasT,
            @RequestParam("horasP") int horasP,
            @RequestParam("horaCiclo") int horaCiclo,
            @RequestParam("introduccion") String introduccion,
            @RequestParam("descipcionPrograma") String descipcionPrograma,
            @RequestParam("objetivo") String objetivo,
            @RequestParam("metodologia") String metodologia,
            @RequestParam("sistemaEvaluacion") String sistemaEvaluacion,
            @RequestParam("bibliografia") String bibliografia,
            @RequestParam("actividad") String actividad,
            @RequestParam("ponderacion") int ponderacion
            ) {
        System.out.println(1);
        try {
            //System.out.println(1);
            asignaturaService.AgregarAsig(codigoAsignatura, nombreAsignatura, uv, numeroCorrelativo, ciclo, idAreaC,  idMalla, duracion, horasT, horasP, horaCiclo, introduccion, descipcionPrograma, objetivo, metodologia, sistemaEvaluacion, bibliografia, actividad, ponderacion);
            String mensaje = "Se ha Agregado una Asignatura.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ya existe una Asignatura con ese nombre.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

}
