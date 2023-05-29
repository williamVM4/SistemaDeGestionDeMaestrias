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
import org.springframework.web.bind.annotation.PathVariable;
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
    public String Asignatura(Model model, RedirectAttributes redirectAttributes, @PathVariable("idPlanEstudio") Long idPlanEstudio) {
        var areaC = areaConocimientoService.listarAreaConocimientos();
        Long idMallaC = asignaturaService.encontrarMalla(idPlanEstudio);
        model.addAttribute("areaC", areaC);
        model.addAttribute("idMallaC", idMallaC);
        model.addAttribute("idPlanEstudio", idPlanEstudio);
        return "Asignatura/index";
    }

    @GetMapping("/Asignatura/data")
    @ResponseBody
    public DataTablesOutput<Asignatura> getAsignatura(@Valid DataTablesInput input,
            @RequestParam("idMallaCurricular") Long idMallaCurricular) {
        return asignaturaService.listarAsignaturaFiltrado(input, idMallaCurricular);
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
            String mensaje = "Se ha Agregado una Asignatura.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ya existe una Asignatura con ese nombre.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PostMapping("/EliminarAsignatura/{idAsignatura}")
    public ResponseEntity EliminarPlanEstudio(Asignatura asignatura) {
        try {
            asignaturaService.eliminarA(asignatura);
            String mensaje = "Se ha eliminado el plan de estudio correctamente.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ha ocurrido un error al eliminar el plan de estudio.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @PostMapping("/ActualizarAsignatura")
    public ResponseEntity ActualizarAsignatura(Asignatura asignatura, RedirectAttributes redirectAttributes) {
        try {
            Asignatura asignaturaExsistente = asignaturaService.encontrarA(asignatura);
            asignaturaExsistente.setCiclo(asignatura.getCiclo());
            asignaturaExsistente.setIdAreaConocimiento(asignatura.getIdAreaConocimiento());
            asignaturaExsistente.setNombreMateria(asignatura.getNombreMateria());
            asignaturaExsistente.setNumeroCorrelativo(asignatura.getNumeroCorrelativo());
            asignaturaExsistente.setUnidadesValorativas(asignatura.getUnidadesValorativas());
            asignaturaExsistente.setCodAsignatura(asignatura.getCodAsignatura());
            asignaturaService.actualizarA(asignaturaExsistente);
            String mensaje = "Se ha actualizado la Actividad correctamente.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "No se puede Actualizar la actividad";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
        @GetMapping("/ObtenerAsignatura/{id}")
    public ResponseEntity<Asignatura> obtenerAsignatura(@PathVariable Long id) {
        Asignatura actividad = asignaturaService.encontrarAsig(id);
        if (actividad != null) {
            return ResponseEntity.ok(actividad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
