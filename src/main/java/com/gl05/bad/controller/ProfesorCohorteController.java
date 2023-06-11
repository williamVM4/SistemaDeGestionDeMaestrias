package com.gl05.bad.controller;

import com.gl05.bad.domain.Asignatura;
import com.gl05.bad.domain.Cohorte;
import com.gl05.bad.domain.Maestria;
import com.gl05.bad.domain.MallaCurricular;
import com.gl05.bad.domain.PlanEstudio;
import com.gl05.bad.domain.ProfesorAsignatura;
import com.gl05.bad.domain.ProfesorCohorte;
import com.gl05.bad.servicio.AsignaturaService;
import com.gl05.bad.servicio.BitacoraServiceImp;
import com.gl05.bad.servicio.CohorteService;
import com.gl05.bad.servicio.MaestriaService;
import com.gl05.bad.servicio.MallaCurricularService;
import com.gl05.bad.servicio.PlanEstudioService;
import com.gl05.bad.servicio.PostuladoCohorteService;
import com.gl05.bad.servicio.ProfesorAsignaturaService;
import com.gl05.bad.servicio.ProfesorCohorteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfesorCohorteController {
  
    @Autowired
    private BitacoraServiceImp bitacoraService;

    @Autowired
    private PostuladoCohorteService postuladoCohorteService;

    @Autowired
    private ProfesorCohorteService profesorCohorteService;

    @Autowired
    private CohorteService cohorteService;

    @Autowired
    private MaestriaService maestriaService;

    @Autowired
    private PlanEstudioService planEstudioService;

    @Autowired
    private MallaCurricularService mallaCurricularService;

    @Autowired
    private AsignaturaService asignaturaService;

    @Autowired
    private ProfesorAsignaturaService profesorAsignaturaService;

    @GetMapping("/PostuladosCohorte/{idCohorte}")
    public String PostuladosCohorte(Model model, RedirectAttributes redirectAttributes, @PathVariable("idCohorte") Long idCohorte) {
        var postulados = postuladoCohorteService.listarAspiranteProfesor(idCohorte);
        Cohorte cohorteObj = new Cohorte(idCohorte);
        Cohorte cohorte = cohorteService.encontrarCohorte(cohorteObj);
        Maestria idMaestria = cohorte.getIdMaestria();
        Maestria maestria = maestriaService.encontrarMaestria(idMaestria);
        short estadoPlanVigente = 1;
        PlanEstudio planEstudio = planEstudioService.encontrarPlanEstudioPorIdMaestria(maestria, estadoPlanVigente);
        MallaCurricular mallaCurricular = mallaCurricularService.obtenerMallaCurricularPlan(planEstudio);
        List<Asignatura> asignaturas = asignaturaService.encontrarAsignaturasPorMalla(mallaCurricular);
        model.addAttribute("asignaturas", asignaturas);
        model.addAttribute("postulados", postulados);
        model.addAttribute("idCohorte", idCohorte);
        return "ProfesorCohorte/index";
    }


    @PostMapping("/ContratarAspirante")
    public ResponseEntity ContratarAspirante(ProfesorCohorte profesorCohorte,
            RedirectAttributes redirectAttributes,
            @RequestParam("idAsignatura") Long idAsignatura) {

        try {
            ProfesorCohorte profesor = profesorCohorteService.contratarP(profesorCohorte);
            ProfesorAsignatura asignaturaProfesor = new ProfesorAsignatura();
            Asignatura asignatura = new Asignatura(idAsignatura);
            asignaturaProfesor.setIdAsignatura(asignatura);
            asignaturaProfesor.setIdProfesor(profesor);

            profesorAsignaturaService.agregarA(asignaturaProfesor);
            String mensaje = "Se ha Contratado con exito.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ocurrio un error al intentar contratar.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }

    @GetMapping("/ProfesorCohorte/{idCohorte}")
    public String ProfesorCohorte(Model model, RedirectAttributes redirectAttributes, @PathVariable("idCohorte") Long idCohorte) {
        var profesorCohorte = profesorCohorteService.listaProfesoresC(idCohorte);
        model.addAttribute("profesorCohorte", profesorCohorte);
        return "ProfesorCohorte/gestionarProfesores";
    }

    @PostMapping("/EliminarProfesor/{idProfesor}")
    public ResponseEntity EliminarProfesor(ProfesorCohorte profesorCohorte) {
        try {
            System.out.println(profesorCohorte);
            profesorCohorteService.eliminarPC(profesorCohorte);
            String mensaje = "Se ha eliminado el profesor correctamente.";
            return ResponseEntity.ok(mensaje);
        } catch (Exception e) {
            String error = "Ha ocurrido un error al eliminar el profesor.";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}
