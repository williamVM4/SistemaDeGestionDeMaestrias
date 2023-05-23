package com.gl05.bad.controller;

import com.gl05.bad.domain.AspiranteProfesor;
import com.gl05.bad.domain.Correo;
import com.gl05.bad.domain.ExperienciaLaboral;
import com.gl05.bad.domain.RedSocial;
import com.gl05.bad.domain.Telefono;
import com.gl05.bad.servicio.AspiranteProfesorService;
import com.gl05.bad.servicio.PaisService;
import com.gl05.bad.servicio.CorreoService;
import com.gl05.bad.servicio.ExperienciaLaboralService;
import com.gl05.bad.servicio.RedSocialService;
import com.gl05.bad.servicio.TelefonoService;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
public class AspiranteProfesorController {
    
    @Autowired
    private AspiranteProfesorService aspiranteService;
    
    @Autowired
    private PaisService paisService;
    
    @Autowired
    private CorreoService correoService;
    
    @Autowired
    private RedSocialService redSocialService;
    
    @Autowired
    private ExperienciaLaboralService experienciaLaboralService;
    
    @Autowired
    private TelefonoService telefonoService;
    
    @GetMapping("/PerfilAspiranteProfesor/{idAspiranteProfesor}")
    public String perfilAspiranteProfesor(Model model, AspiranteProfesor aspirante) {
        model.addAttribute("pageTitle", "PerfilAspiranteProfesor");
        var aspiranteNew = aspiranteService.encontrarAP(aspirante);
        //Se cargan para la edicion de la informacion general del aspirante
        List<String> sexos = listarSexos();
        List<String> generos = listarGeneros();
        List<String> estadosCiviles = listarEstados();
        List<String> nacionalidades = listarNacionalidades();
        
        //Manejo de correos
        var correos = correoService.listarCorreos();
        List<String> tiposCorreo = listarTiposCorreos();
        List<Correo> correosAspirante = new ArrayList();
        for (var eCorreo : correos) {
            if(eCorreo.getIdListCorreo() == (int) aspiranteNew.getIdListCorreo()){
                correosAspirante.add(eCorreo);
            }
        }
        
        //Manejo de telefonos
        var telefonos = telefonoService.listarTelefonos();
        List<String> tiposTelefono = listarTipoTelefono();
        List<Telefono> telefonosAspirante = new ArrayList();
        for (var eTelefono: telefonos) {
            if(eTelefono.getIdListTelefono() == (int) aspiranteNew.getIdListTelefono()){
                telefonosAspirante.add(eTelefono);
            }
        }
        
        //Manejo de redes sociales
        var redesSociales = redSocialService.listarRedesSocial();
        List<String> tiposRedSocial = listarRedesSociales();
        List<RedSocial> redesSocialesAspirante = new ArrayList();
        for (var eRedSocial : redesSociales) {
            if(eRedSocial.getIdListRs() == (int) aspiranteNew.getIdListRs()){
                redesSocialesAspirante.add(eRedSocial);
            }
        }
        
        //Manejo de experiencias laborales
        var experienciasLaborales = experienciaLaboralService.listarExperienciasLaboral();
        List<ExperienciaLaboral> experienciasLaboralesAspirante = new ArrayList();
        for (var eExperienciaLaboral : experienciasLaborales) {
            if(eExperienciaLaboral.getIdListEl() == (int) aspiranteNew.getIdListEl()){
                experienciasLaboralesAspirante.add(eExperienciaLaboral);
            }
        }
        
        //Manejo de paises
        var paises = paisService.listarPaises();
        String paisSeleccionado="";
        if (aspiranteNew.getIdPais() != null) {
            for (var pais : paises) {
                if(pais.getIdPais() == (int) aspiranteNew.getIdPais()){
                    paisSeleccionado=pais.getNombrePais();
                }
            }
        }
        
        //Manejo de imagenes
        Blob imagenBlob = aspiranteNew.getFotografiaAp();
        String imagenBase64 = null;

        if (imagenBlob != null) {
            try {
                byte[] bytes = imagenBlob.getBytes(1, (int) imagenBlob.length());
                String base64Encoded = Base64Utils.encodeToString(bytes);
                bytes = null;
                imagenBase64 = new String(base64Encoded.getBytes(StandardCharsets.UTF_8));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        //model.addAttribute("atestados", atestadoCoordinador);
        //model.addAttribute("tiposTitulos", tiposTitulos);
        model.addAttribute("imagenBase64", imagenBase64);
        //model.addAttribute("documentos", documentos);
        model.addAttribute("aspiranteAP", aspiranteNew);
        model.addAttribute("paises", paises);
        model.addAttribute("sexos", sexos);
        model.addAttribute("generos", generos);
        model.addAttribute("estadosCiviles", estadosCiviles);
        model.addAttribute("nacionalidades", nacionalidades);
        model.addAttribute("paisSeleccionado", paisSeleccionado);
        model.addAttribute("correos", correosAspirante);
        model.addAttribute("tiposCorreo", tiposCorreo);
        model.addAttribute("telefonos", telefonosAspirante);
        model.addAttribute("tiposTelefonos", tiposTelefono);
        model.addAttribute("redesSociales", redesSocialesAspirante);
        model.addAttribute("tiposRedesSociales", tiposRedSocial);
        model.addAttribute("experienciasLaborales", experienciasLaboralesAspirante);
        return "/AspiranteProfesor/perfilAspiranteProfesor";
    }
        
    @GetMapping("/GestionarAspiranteProfesor")
    public String mostrarAspirantesProfesor(Model model) {
        model.addAttribute("pageTitle", "GestionarAspiranteProfesor");
        var elementos = aspiranteService.listarAspirantes();
        model.addAttribute("aspirantesAP", elementos);
        return "/AspiranteProfesor/gestionarAspiranteProfesor";
    }
    
    @PostMapping("/AgregarAspiranteProfesor")
    public String agregarAspiranteProfesor(AspiranteProfesor aspirante, RedirectAttributes redirectAttributes) {
        try {
            aspiranteService.agregarAP(aspirante);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado un aspirante a profesor.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe un aspirante a profesor con ese identificador.");
        }
        return "redirect:/GestionarAspiranteProfesor";  
    }
    
    @PostMapping("/ActualizarAspiranteProfesor/{idAspiranteProfesor}")
    public String actualizarAspiranteProfesor(AspiranteProfesor aspirante, @PathVariable("idAspiranteProfesor") int idAspiranteProfesor, RedirectAttributes redirectAttributes) throws ParseException{
        
        try {
            //Arreglando formato del DUI, NIT, NUP, DOC PERSONAL, PASAPORTE
            String dui=aspirante.getDuiAp();
            dui=dui.replace("-","");
            aspirante.setDuiAp(dui);
            String nit=aspirante.getNitAp();
            nit=nit.replace("-","");
            aspirante.setNitAp(nit);
            String nup=aspirante.getNupAp();
            aspirante.setNupAp(nup);
            String pasaporte=aspirante.getPasaporteAp();
            pasaporte=pasaporte.replace("-","");
            pasaporte=pasaporte.replace("_","");
            aspirante.setPasaporteAp(pasaporte);
            String docPersonal=aspirante.getDocPersonalAp();
            docPersonal=docPersonal.replace("-","");
            docPersonal=docPersonal.replace("_","");
            aspirante.setDocPersonalAp(docPersonal);
            //Convirtiendo el pais en entero
            int idPais = (int)(aspirante.getIdPais());
            aspirante.setIdPais(idPais);
            aspiranteService.actualizarAP(aspirante);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha actualizado la información general del aspirante a profesor.");
        } catch(Exception e) {
            //redirectAttributes.addFlashAttribute("error", "No se actualizó la información general del aspirante a profesor.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfilAspiranteProfesor/{idAspiranteProfesor}").buildAndExpand(idAspiranteProfesor).toUriString();
        return "redirect:" + redirectUrl;  
    }
    
    
    @GetMapping("/EliminarAspiranteProfesor/{idAspiranteProfesor}")
    public String eliminarAspiranteProfesor(AspiranteProfesor aspirante, RedirectAttributes redirectAttributes) {
        try {
            aspiranteService.eliminarAP(aspirante);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado un aspirante a profesor.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el aspirante a profesor.");
        }
        return "redirect:/GestionarAspiranteProfesor";
    }
    
    @PostMapping("/AgregarCorreoAspiranteProfesor/{idAspiranteProfesor}/{idListCorreo}")
    public String agregarCorreoAspiranteProfesor(
        @RequestParam("tipoCorreo") String tipoCorreo,
        @RequestParam("correo") String correo,
        @PathVariable("idListCorreo") int idListCorreo, 
        @PathVariable("idAspiranteProfesor")int idAspiranteProfesor, 
        RedirectAttributes redirectAttributes) {
        try {
            Correo correoNew = new Correo();
            correoNew.setIdListCorreo(idListCorreo);
            correoNew.setCorreo(correo);
            correoNew.setTipoCorreo(tipoCorreo);
            correoService.agregarC(correoNew);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado un correo.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya se encuentra registrado el correo.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfilAspiranteProfesor/{idAspiranteProfesor}").buildAndExpand(idAspiranteProfesor).toUriString();
        return "redirect:" + redirectUrl;   
    }
    
    @PostMapping("/AgregarTelefonoAspiranteProfesor/{idAspiranteProfesor}/{idListTelefono}")
    public String agregarTelefonoAspiranteProfesor(
        @RequestParam("tipoTelefono") String tipoTelefono,
        @RequestParam("numero") String numero,
        @PathVariable("idListTelefono") int idListTelefono, 
        @PathVariable("idAspiranteProfesor")int idAspiranteProfesor, 
        RedirectAttributes redirectAttributes) {
        try {
            Telefono telefonoNew = new Telefono();
            telefonoNew.setIdListTelefono(idListTelefono);
            telefonoNew.setNumero(numero);
            telefonoNew.setTipoTelefono(tipoTelefono);
            telefonoService.agregarT(telefonoNew);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado un telefono.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya se encuentra registrado el telefono.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfilAspiranteProfesor/{idAspiranteProfesor}").buildAndExpand(idAspiranteProfesor).toUriString();
        return "redirect:" + redirectUrl;   
    }
    
    @PostMapping("/AgregarExperienciaLaboralAspiranteProfesor/{idAspiranteProfesor}/{idListEl}")
    public String agregarExperienciaLaboralAspiranteProfesor(
        @RequestParam("nombreInstitucion") String nombreInstitucion,
        @RequestParam("cargo") String cargo,
        @RequestParam("funciones") String funciones,
        @RequestParam("periodoInicio") String periodoInicio,
        @RequestParam("periodoFin") String periodoFin,
        @PathVariable("idListEl") int idListEl, 
        @PathVariable("idAspiranteProfesor")int idAspiranteProfesor, 
        RedirectAttributes redirectAttributes) throws ParseException {
        try {
            SimpleDateFormat fechaInicio = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaInicioC = fechaInicio.parse(periodoInicio);
            SimpleDateFormat fechaFin = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaFinC = fechaFin.parse(periodoFin);
            ExperienciaLaboral experienciaLaboralNew = new ExperienciaLaboral();
            experienciaLaboralNew.setIdListEl(idListEl);
            experienciaLaboralNew.setNombreInstitucion(nombreInstitucion);
            experienciaLaboralNew.setCargo(cargo);
            experienciaLaboralNew.setFunciones(funciones);
            experienciaLaboralNew.setPeriodoInicio(fechaInicioC);
            experienciaLaboralNew.setPeriodoFin(fechaFinC);
            experienciaLaboralService.agregarEL(experienciaLaboralNew);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado una experiencia laboral.");
        } catch(ParseException e) {
            redirectAttributes.addFlashAttribute("error", "No en el ingreso de la experiencia laboral .");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfilAspiranteProfesor/{idAspiranteProfesor}").buildAndExpand(idAspiranteProfesor).toUriString();
        return "redirect:" + redirectUrl;   
    }
    
    @PostMapping("/AgregarRedSocialAspiranteProfesor/{idAspiranteProfesor}/{idListRs}")
    public String agregarRedSocialAspiranteProfesor(
        @RequestParam("nombreRs") String nombreRs,
        @RequestParam("link") String link,
        @PathVariable("idListRs") int idListRs, 
        @PathVariable("idAspiranteProfesor")int idAspiranteProfesor, 
        RedirectAttributes redirectAttributes) {
        try {
            RedSocial redSocialNew = new RedSocial();
            redSocialNew.setIdListRs(idListRs);
            redSocialNew.setNombreRs(nombreRs);
            redSocialNew.setLink(link);
            redSocialService.agregarRS(redSocialNew);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado una red social.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya se encuentra registrado la red social.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfilAspiranteProfesor/{idAspiranteProfesor}").buildAndExpand(idAspiranteProfesor).toUriString();
        return "redirect:" + redirectUrl;   
    }
    
    @GetMapping("/EliminarCorreoAspiranteProfesor/{idCorreo}/{idAspiranteProfesor}")
    public String eliminarCorreoAspiranteProfesor(Correo correo, @PathVariable("idAspiranteProfesor")int idAspiranteProfesor, RedirectAttributes redirectAttributes) {
        try {
            correoService.eliminarC(correo);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado el correo.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el correo.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfilAspiranteProfesor/{idAspiranteProfesor}").buildAndExpand(idAspiranteProfesor).toUriString();
        return "redirect:" + redirectUrl;
    }
    
    @GetMapping("/EliminarTelefonoAspiranteProfesor/{idTelefono}/{idAspiranteProfesor}")
    public String eliminarTelefonoAspiranteProfesor(Telefono telefono, @PathVariable("idAspiranteProfesor")int idAspiranteProfesor, RedirectAttributes redirectAttributes) {
        try {
            telefonoService.eliminarT(telefono);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado el telefono.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el telefono.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfilAspiranteProfesor/{idAspiranteProfesor}").buildAndExpand(idAspiranteProfesor).toUriString();
        return "redirect:" + redirectUrl;
    }
    
    @GetMapping("/EliminarRedSocialAspiranteProfesor/{idRs}/{idAspiranteProfesor}")
    public String eliminarRedSocialAspiranteProfesor(RedSocial redSocial, @PathVariable("idAspiranteProfesor")int idAspiranteProfesor, RedirectAttributes redirectAttributes) {
        try {
            redSocialService.eliminarRS(redSocial);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado una red social.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar la red social.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfilAspiranteProfesor/{idAspiranteProfesor}").buildAndExpand(idAspiranteProfesor).toUriString();
        return "redirect:" + redirectUrl;
    }
    
    @GetMapping("/EliminarExperienciaLaboralAspiranteProfesor/{idEl}/{idAspiranteProfesor}")
    public String eliminarExperienciaLaboralAspiranteProfesor(ExperienciaLaboral experienciaLaboral, @PathVariable("idAspiranteProfesor")int idAspiranteProfesor, RedirectAttributes redirectAttributes) {
        try {
            experienciaLaboralService.eliminarEL(experienciaLaboral);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado la experiencia laboral.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar la experiencia laboral.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/PerfilAspiranteProfesor/{idAspiranteProfesor}").buildAndExpand(idAspiranteProfesor).toUriString();
        return "redirect:" + redirectUrl;
    }
    
    @PostMapping("/actualizarFotoAP/{idAspiranteProfesor}")
    public String actualizarFoto(
        @RequestParam Map<String, MultipartFile> campos,
        @PathVariable("idAspiranteProfesor") Long idAspiranteProfesor,
        RedirectAttributes redirectAttributes) {
        AspiranteProfesor aspirante = new AspiranteProfesor();
        try {
            aspirante.setIdAspiranteProfesor(idAspiranteProfesor);
            for (Map.Entry<String, MultipartFile> entry : campos.entrySet()) {
                String nombreCampo = entry.getKey();
                MultipartFile campo = entry.getValue();

                byte[] fileBytes = campo.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(fileBytes);

                aspiranteService.actualizarFoto(aspirante, nombreCampo, blob);
            }

            redirectAttributes.addFlashAttribute("mensaje", "Se han actualizado los campos correctamente.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Sucedió un error al actualizar los campos.");
        }

        return "redirect:/PerfilAspiranteProfesor/" + aspirante.getIdAspiranteProfesor();  
    }

    public List<String> listarGeneros() {
        List<String> generos = Arrays.asList("Masculino", "Femenino","LGBTIQ+","Prefiero no decirlo");        
        return generos;
    }
    public List<String> listarSexos() {
        List<String> sexos= Arrays.asList("Hombre", "Mujer");  
        return sexos;
    }
    public List<String> listarEstados() {
        List<String> estados = Arrays.asList("Soltero", "Casado","Divorciado","Separado","Acompañado","Unión libre");  
        return estados;
    }
    public List<String> listarNacionalidades() {
        List<String> estados = Arrays.asList("Nacimiento", "Naturalización", "Residencia");
        return estados;
    }
    public List<String> listarTiposCorreos() {
        List<String> tiposCorreos = Arrays.asList("Trabajo", "Privado","Personal","Institucional");
        return tiposCorreos;
    }
    public List<String> listarRedesSociales() {
        List<String> redesSociales = Arrays.asList("LinkedIn", "Twitter", "Instagram", "Facebook", "YouTube", "Slack", "GitHub");
        return redesSociales;
    }
    public List<String> listarTipoTelefono() {
        List<String> tipoTelefono = Arrays.asList("Casa", "Oficina","Fijo", "Móvil");
        return tipoTelefono;
    }
    
}