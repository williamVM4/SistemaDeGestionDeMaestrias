package com.gl05.bad.controller;

import com.gl05.bad.domain.Asignatura;
import com.gl05.bad.servicio.AreaConocimientoService;
import com.gl05.bad.servicio.AsignaturaService;
import java.util.Arrays;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
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

    @GetMapping("/DetallePlanEstudio/{idPlanEstudio}")
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
            @RequestParam("uv") Integer uv,
            @RequestParam("numeroCorrelativo") Integer numeroCorrelativo,
            @RequestParam("ciclo") Integer ciclo,
            @RequestParam("idAreaC") long idAreaC,
            @RequestParam("idMalla") long idMalla,
            @RequestParam("duracion") Integer duracion,
            @RequestParam("horasT") Integer horasT,
            @RequestParam("horasP") Integer horasP,
            @RequestParam("horaCiclo") Integer horaCiclo,
            @RequestParam("introduccion") String introduccion,
            @RequestParam("descipcionPrograma") String descipcionPrograma,
            @RequestParam("objetivo") String objetivo,
            @RequestParam("metodologia") String metodologia,
            @RequestParam("sistemaEvaluacion") String sistemaEvaluacion,
            @RequestParam("bibliografia") String bibliografia,
            @RequestParam MultiValueMap<String, String> formData
    ) {
        try {
            String[] actividad = formData.get("actividad[]").toArray(new String[0]);
            int[] ponderacion = formData.get("ponderacion[]").stream().mapToInt(Integer::parseInt).toArray();
            String ponderacionString = Arrays.stream(ponderacion)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(","));
            String actividadString = String.join(",", actividad);

            System.out.println(actividadString);
            System.out.println(ponderacionString);
            asignaturaService.AgregarAsig(codigoAsignatura, nombreAsignatura, uv, numeroCorrelativo, ciclo, idAreaC, idMalla, duracion, horasT, horasP, horaCiclo, introduccion, descipcionPrograma, objetivo, metodologia, sistemaEvaluacion, bibliografia, actividadString, ponderacionString);
            String mensaje = "Se ha Agregado una Asignatura." + Arrays.toString(actividad);
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ya existe una Asignatura con ese nombre.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

}
