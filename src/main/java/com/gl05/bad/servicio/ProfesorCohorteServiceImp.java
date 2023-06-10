package com.gl05.bad.servicio;

import com.gl05.bad.dao.ProfesorCohorteDao;
import com.gl05.bad.domain.AspiranteProfesor;
import com.gl05.bad.domain.Cohorte;
import com.gl05.bad.domain.ProfesorCohorte;
import com.gl05.bad.domain.Usuario;
import com.gl05.bad.servicio.UserServiceImp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class ProfesorCohorteServiceImp implements ProfesorCohorteService {

    @Autowired
    private ProfesorCohorteDao profesorCohorteDao;
    
    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private UserServiceImp userServiceImp;
    
    
    @Override
    public ProfesorCohorte contratarP(ProfesorCohorte profesorCohorte) {
        Cohorte cohorte = profesorCohorte.getIdCohorte();
        AspiranteProfesor aspiranteProfesor = profesorCohorte.getIdAspiranteProfesor();
        Long idUser = Long.valueOf(aspiranteProfesor.getIdusuario());
        Usuario usuario = userServiceImp.encontrarUsuario(idUser);
        String asunto= "Contratación en cohorte";
        String mensaje= "¡Felicidades!  Ha sido contratado en la cohorte " +cohorte.getNombreCohorte()+" .";
        ProfesorCohorte profesor = profesorCohorteDao.save(profesorCohorte);
        enviarCorreo(usuario.getEmail(), asunto, mensaje);
        return profesor;
    }
    
    public void enviarCorreo(String correoDestino, String asunto, String mensaje){
      SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setTo(correoDestino);
      mailMessage.setSubject(asunto);
      mailMessage.setText(mensaje);
      mailSender.send(mailMessage);
    };

    @Override
    public List<ProfesorCohorte> listaProfesoresC(Long idCohorte) {
        return (List<ProfesorCohorte>) profesorCohorteDao.findProfesByCohorteId(idCohorte);
    }

    @Override
    public void eliminarPC(ProfesorCohorte profesorCohorte) {
        profesorCohorteDao.delete(profesorCohorte);
    }

}
