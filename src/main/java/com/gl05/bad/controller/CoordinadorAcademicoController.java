package com.gl05.bad.controller;

import com.gl05.bad.domain.AspiranteProfesor;
import com.gl05.bad.domain.CoordinadorAcademico;
import com.gl05.bad.domain.Correo;
import com.gl05.bad.domain.Documento;
import com.gl05.bad.domain.ListadoDocumentacionPersonal;
import com.gl05.bad.domain.Telefono;
import com.gl05.bad.servicio.CoordinadorAcademicoService;
import com.gl05.bad.servicio.CorreoService;
import com.gl05.bad.servicio.DocumentacionPersonalService;
import com.gl05.bad.servicio.DocumentoService;
import com.gl05.bad.servicio.ExperienciaLaboralService;
import com.gl05.bad.servicio.PaisService;
import com.gl05.bad.servicio.RedSocialService;
import com.gl05.bad.servicio.TelefonoService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class CoordinadorAcademicoController {

    @Autowired
    private CoordinadorAcademicoService coordinadorService;

    @Autowired
    private DocumentoService docService;

    @Autowired
    private DocumentacionPersonalService listDocService;
  
    @Autowired
    private PaisService paisService;
    
    @Autowired
    private CorreoService correoService;
    
    @Autowired
    private TelefonoService telefonoService;
  
    @GetMapping("/perfilCoordinadorAcademico/{idCoorAca}")
    public String perfilCoordinadorAcademico(Model model, CoordinadorAcademico coordinador) {
        model.addAttribute("pageTitle", "PerfilCoordinadorAcademico");
        
        var elemento = coordinadorService.encontrarCA(coordinador);
      
        Blob imagenBlob = elemento.getFotografiaCa();
        String imagenBase64 = null;

        if (imagenBlob != null) {
            try {
                byte[] bytes = imagenBlob.getBytes(1, (int) imagenBlob.length());
                String base64Encoded = Base64Utils.encodeToString(bytes);
                imagenBase64 = new String(base64Encoded.getBytes(StandardCharsets.UTF_8));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        //Manejo de correos
        var correos = correoService.listarCorreos();
        List<String> tiposCorreo = listarTiposCorreos();
        List<Correo> correosCoordinador = new ArrayList();
        for (var eCorreo : correos) {
            if(eCorreo.getIdListCorreo() == (int) elemento.getIdListCorreo()){
                correosCoordinador.add(eCorreo);
            }
        }
        
        //Manejo de telefonos
        var telefonos = telefonoService.listarTelefonos();
        List<String> tiposTelefono = listarTipoTelefono();
        List<Telefono> telefonosCoordinador = new ArrayList();
        for (var eTelefono: telefonos) {
            if(eTelefono.getIdListTelefono() == (int) elemento.getIdListTelefono()){
                telefonosCoordinador.add(eTelefono);
            }
        }
        
        //Se cargan para la edicion de la informacion general
        List<String> sexos = listarSexos();
        List<String> generos = listarGeneros();
        List<String> estadosCiviles = listarEstados();
        List<String> nacionalidades = listarNacionalidades();
        
        //Manejo de paises
        var paises = paisService.listarPaises();
        String paisSeleccionado="";
        if (elemento.getIdPais() != null) {
            for (var pais : paises) {
                if(pais.getIdPais() == (int) elemento.getIdPais()){
                    paisSeleccionado=pais.getNombrePais();
                }
            }
        }
        
        model.addAttribute("imagenBase64", imagenBase64);
        model.addAttribute("coordinadorCA", elemento);
        model.addAttribute("correos", correosCoordinador);
        model.addAttribute("tiposCorreo", tiposCorreo);
        model.addAttribute("telefonos", telefonosCoordinador);
        model.addAttribute("tiposTelefonos", tiposTelefono);
        model.addAttribute("paises", paises);
        model.addAttribute("sexos", sexos);
        model.addAttribute("generos", generos);
        model.addAttribute("estadosCiviles", estadosCiviles);
        model.addAttribute("nacionalidades", nacionalidades);
        model.addAttribute("paisSeleccionado", paisSeleccionado);
        return "/coordinadorAcademico/perfilCoordinadorAcademico";
    }

    @GetMapping("/gestionarCoordinadorAcademico")
    public String mostrarCoordinadoresAcademicos(Model model) {
        model.addAttribute("pageTitle", "ViewCoordinadoresAcademicos");

        var elementos = coordinadorService.listarCoordinadores();

        model.addAttribute("coordinadoresAC", elementos);
        return "/coordinadorAcademico/index";
    }
 
    @PostMapping("/guardarCA")
    public String agregarCoordinadorAcademico(
        @RequestParam("codCa") String codCa,
        @RequestParam("nombresCa") String nombresCa,
        @RequestParam("apellidosCa") String apellidosCa,
        RedirectAttributes redirectAttributes) {

        try {
            coordinadorService.proIsertarCA(codCa, nombresCa, apellidosCa);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha ingresado un coordinador.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ya existe un coordinador con ese identificador.");
        }

        return "redirect:/gestionarCoordinadorAcademico";  
    }
    
    @GetMapping("/eliminarCoordinadorAcademico/{idCoorAca}")
    public String eliminarCoordinadorAcademico(CoordinadorAcademico coordinador, RedirectAttributes redirectAttributes) {
        try {
            coordinadorService.eliminarCA(coordinador);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado un Coordinador Académico.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el Coordinador Académico.");
        }
        return "redirect:/gestionarCoordinadorAcademico";
    }

    @PostMapping("/actualizarFoto/{idCoorAca}")
    public String actualizarFoto(
        @RequestParam Map<String, MultipartFile> campos,
        @PathVariable("idCoorAca") Long idCoorAca,
        RedirectAttributes redirectAttributes) {
        CoordinadorAcademico coordinador = new CoordinadorAcademico();
        try {
            coordinador.setIdCoorAca(idCoorAca);
            for (Map.Entry<String, MultipartFile> entry : campos.entrySet()) {
                String nombreCampo = entry.getKey();
                MultipartFile campo = entry.getValue();

                byte[] fileBytes = campo.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(fileBytes);

                coordinadorService.actualizarCampo(coordinador, nombreCampo, blob);
            }

            redirectAttributes.addFlashAttribute("mensaje", "Se han actualizado los campos correctamente.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Sucedió un error al actualizar los campos.");
        }

        return "redirect:/perfilCoordinadorAcademico/" + coordinador.getIdCoorAca();  
    }

    @PostMapping("/actualizarDocumento/{idCoorAca}")
    public String actualizarDocumento(
        @RequestParam("tipoDocumento") String tipoDocumento,
        @RequestParam Map<String, MultipartFile> campos,
        @PathVariable("idCoorAca") Long idCoorAca,
        RedirectAttributes redirectAttributes) {
      
        Documento documento = new Documento();
        CoordinadorAcademico coordinador = new CoordinadorAcademico();
        CoordinadorAcademico coordinadorExistente = new CoordinadorAcademico();
        ListadoDocumentacionPersonal listaDoc = new ListadoDocumentacionPersonal();
        
        try {
            coordinador.setIdCoorAca(idCoorAca);
            coordinadorExistente=coordinadorService.encontrarCA(coordinador);
            listaDoc.setIdListDp(Long.valueOf(coordinadorExistente.getIdListDp()));
            
            documento.setIdListDp(listaDoc);
            documento.setTipoFile(tipoDocumento);
            for (Map.Entry<String, MultipartFile> entry : campos.entrySet()) {
              try{
                String tipoCampo = entry.getKey();
                MultipartFile campo = entry.getValue();

                byte[] fileBytes = campo.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(fileBytes);
                
                documento.setDocFile(blob);

                docService.agregarDocumento(documento);
              }catch(IOException e){
                redirectAttributes.addFlashAttribute("error", "El documento no cumple con las especificaciones dadas");
              }
            }
            redirectAttributes.addFlashAttribute("mensaje", "Se han actualizado sus documentos.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Sucedió un error al subir el documento");
        }

        return "redirect:/perfilCoordinadorAcademico/" + coordinadorExistente.getIdCoorAca();  
    }
    
  /*@PostMapping("/guardarCA")
  public String guardarCoordinadorAcademico(CoordinadorAcademico coordinador) {
      coordinadorService.agregarCA(coordinador);
      return "redirect:/viewCoordinadoresAcademicos";
  }actualizarFoto*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @PostMapping("/ActualizarCoordinadorAcademico/{idCoorAca}")
    public String actualizarCoordinadorAcademico (CoordinadorAcademico coordinadorAcademico, @PathVariable("idCoorAca") int idCoorAca, RedirectAttributes redirectAttributes) throws ParseException{
        
        //try {
            //Arreglando formato del DUI, NIT, NUP, DOC PERSONAL, PASAPORTE
            String dui=coordinadorAcademico.getDuiCa();
            dui=dui.replace("-","");
            coordinadorAcademico.setDuiCa(dui);
            String nit=coordinadorAcademico.getNitCa();
            nit=nit.replace("-","");
            coordinadorAcademico.setNitCa(nit);
            String nup=coordinadorAcademico.getNupCa();
            coordinadorAcademico.setNupCa(nup);
            String pasaporte=coordinadorAcademico.getPasaporteCa();
            pasaporte=pasaporte.replace("-","");
            pasaporte=pasaporte.replace("_","");
            coordinadorAcademico.setPasaporteCa(pasaporte);
            String docPersonal=coordinadorAcademico.getDocPersonalCa();
            docPersonal=docPersonal.replace("-","");
            docPersonal=docPersonal.replace("_","");
            coordinadorAcademico.setDocPersonalCa(docPersonal);
            //Convirtiendo el pais en entero
            int idPais = (int)(coordinadorAcademico.getIdPais());
            coordinadorAcademico.setIdPais(idPais);
            coordinadorService.actualizarCA(coordinadorAcademico);
            //redirectAttributes.addFlashAttribute("mensaje", "Se ha actualizado la información general del coordinador académico.");
        /*} catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "No se actualizó la información general del coordinador académico.");
        }*/
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/perfilCoordinadorAcademico/{idCoorAca}").buildAndExpand(idCoorAca).toUriString();
        return "redirect:" + redirectUrl;  
    } 
    
    @PostMapping("/AgregarCorreoCoordinadorAcademico/{idCoorAca}/{idListCorreo}")
    public String agregarCorreoAspiranteProfesor(
        @RequestParam("tipoCorreo") String tipoCorreo,
        @RequestParam("correo") String correo,
        @PathVariable("idListCorreo") int idListCorreo, 
        @PathVariable("idCoorAca")int idCoorAca, 
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
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/perfilCoordinadorAcademico/{idCoorAca}").buildAndExpand(idCoorAca).toUriString();
        return "redirect:" + redirectUrl;   
    }
    
    @PostMapping("/AgregarTelefonoCoordinadorAcademico/{idCoorAca}/{idListTelefono}")
    public String agregarTelefonoAspiranteProfesor(
        @RequestParam("tipoTelefono") String tipoTelefono,
        @RequestParam("numero") String numero,
        @PathVariable("idListTelefono") int idListTelefono, 
        @PathVariable("idCoorAca")int idCoorAca, 
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
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/perfilCoordinadorAcademico/{idCoorAca}").buildAndExpand(idCoorAca).toUriString();
        return "redirect:" + redirectUrl;   
    }
    
    @GetMapping("/EliminarCorreoCoordinadorAcademico/{idCorreo}/{idCoorAca}")
    public String eliminarCorreoAspiranteProfesor(Correo correo, @PathVariable("idCoorAca")int idCoorAca, RedirectAttributes redirectAttributes) {
        try {
            correoService.eliminarC(correo);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado el correo.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el correo.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/perfilCoordinadorAcademico/{idCoorAca}").buildAndExpand(idCoorAca).toUriString();
        return "redirect:" + redirectUrl;
    }
    
    @GetMapping("/EliminarTelefonoCoordinadorAcademico/{idTelefono}/{idCoorAca}")
    public String eliminarTelefonoAspiranteProfesor(Telefono telefono, @PathVariable("idCoorAca")int idCoorAca, RedirectAttributes redirectAttributes) {
        try {
            telefonoService.eliminarT(telefono);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado el telefono.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el telefono.");
        }
        String redirectUrl = ServletUriComponentsBuilder.fromCurrentContextPath().path("/perfilCoordinadorAcademico/{idCoorAca}").buildAndExpand(idCoorAca).toUriString();
        return "redirect:" + redirectUrl;
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
    public List<String> listarTipoTelefono() {
        List<String> tipoTelefono = Arrays.asList("Casa", "Oficina","Fijo", "Móvil");
        return tipoTelefono;
    }
}

