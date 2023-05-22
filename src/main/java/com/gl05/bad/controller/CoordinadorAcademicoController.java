package com.gl05.bad.controller;

import com.gl05.bad.domain.CoordinadorAcademico;
import com.gl05.bad.domain.Documento;
import com.gl05.bad.domain.ListadoDocumentacionPersonal;
import com.gl05.bad.servicio.CoordinadorAcademicoService;
import com.gl05.bad.servicio.DocumentacionPersonalService;
import com.gl05.bad.servicio.DocumentoService;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
  private DocumentoService docService;

  @Autowired
  private DocumentacionPersonalService listDocService;
  
    @GetMapping("/perfilCoordinadorAcademico/{idCoorAca}")
    public String perfilCoordinadorAcademico(Model model, CoordinadorAcademico coordinador) {
        model.addAttribute("pageTitle", "PerfilCoordinadorAcademico");
        
        var elemento = coordinadorService.encontrarCA(coordinador);
        ListadoDocumentacionPersonal ldp= new ListadoDocumentacionPersonal();
        ldp.setIdListDp(Long.valueOf(elemento.getIdListDp()));        
        var documentos = docService.listarDocumentoPorListado(ldp);
      
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
        model.addAttribute("documentos", documentos);
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

    @GetMapping("/eliminarDocumento/{idCoorAca}/{IdDocumento}")
    public String eliminarDocumento(
            Documento doc, 
            @PathVariable("idCoorAca") Long idCoorAca,
            RedirectAttributes redirectAttributes) {
        try {
            docService.eliminarDocumento(doc);
            redirectAttributes.addFlashAttribute("mensaje", "Se ha eliminado el documento.");
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ha ocurrido un error al eliminar el documento.");
        }
        return "redirect:/perfilCoordinadorAcademico/" + idCoorAca;
    }

    @GetMapping("/archivo/{IdDocumento}")
    public ResponseEntity <byte[]> mostrarArchivoPDF(@PathVariable("IdDocumento") Long id) {
        Documento archivo = new Documento();
        archivo.setIdDocumento(id);
        Documento archivoExistente = docService.encontrarDoc(archivo);

        Blob pdfBlob = archivoExistente.getDocFile();
        byte[] pdfBytes;

        try {
            if (pdfBlob != null && pdfBlob.length() > 0) {
                pdfBytes = pdfBlob.getBytes(1, (int) pdfBlob.length());
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_PDF);
                return new ResponseEntity <>(pdfBytes, headers, HttpStatus.OK);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ResponseEntity.notFound().build();
    }

        

  /*@PostMapping("/guardarCA")
  public String guardarCoordinadorAcademico(CoordinadorAcademico coordinador) {
      coordinadorService.agregarCA(coordinador);
      return "redirect:/viewCoordinadoresAcademicos";
  }actualizarFoto*/
  
}

