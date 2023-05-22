package com.gl05.bad.controller;

import com.gl05.bad.domain.CoordinadorAcademico;
import com.gl05.bad.domain.ListadoDocumentacionPersonal;
import com.gl05.bad.servicio.CoordinadorAcademicoService;
import com.gl05.bad.servicio.DocumentacionPersonalService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
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

@Controller
public class CoordinadorAcademicoController {

  @Autowired
  private CoordinadorAcademicoService coordinadorService;

  @Autowired
  private DocumentacionPersonalService docService;
  
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
        model.addAttribute("imagenBase64", imagenBase64);
        model.addAttribute("coordinadorCA", elemento);
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
    public String actualizarDocumentoPersonal(
        @RequestParam Map<String, MultipartFile> campos,
        @PathVariable("idCoorAca") Long idCoorAca,
        RedirectAttributes redirectAttributes) {
      
        CoordinadorAcademico coordinador = new CoordinadorAcademico();
        CoordinadorAcademico coordinadorExistente = new CoordinadorAcademico();
        ListadoDocumentacionPersonal documento = new ListadoDocumentacionPersonal();
        
        try {
            coordinador.setIdCoorAca(idCoorAca);
            coordinadorExistente=coordinadorService.encontrarCA(coordinador);
            documento.setIdListDp(Long.valueOf(coordinadorExistente.getIdListDp()));
            
            for (Map.Entry<String, MultipartFile> entry : campos.entrySet()) {
              try{
                String nombreCampo = entry.getKey();
                MultipartFile campo = entry.getValue();

                byte[] fileBytes = campo.getBytes();
                Blob blob = new javax.sql.rowset.serial.SerialBlob(fileBytes);

                docService.actualizarCampo(documento, nombreCampo, blob);
              }catch(IOException e){
                e.printStackTrace();
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
  
}

