package com.gl05.bad.servicio;

import com.gl05.bad.dao.DocumentoDao;
import com.gl05.bad.domain.Documento;
import com.gl05.bad.domain.ListadoDocumentacionPersonal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DocumentoServiceImp implements DocumentoService{
  
  @Autowired
  private DocumentoDao docDao;
  
  @Override
  public List<Documento> listarDocumentos() {
    return (List<Documento>)docDao.findAll();
  }

  @Override
  public Documento encontrarDoc(Documento doc) {
    return docDao.findById(doc.getIdDocumento()).orElse(null);
  }

  @Override
  @Transactional
  public void agregarDocumento(Documento doc) {
    docDao.save(doc);
  }

}
