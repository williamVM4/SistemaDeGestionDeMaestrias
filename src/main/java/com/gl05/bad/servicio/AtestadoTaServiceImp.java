package com.gl05.bad.servicio;

import com.gl05.bad.dao.AtestadoTaDao;
import com.gl05.bad.domain.AtestadoTa;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AtestadoTaServiceImp implements AtestadoTaService{

  @Autowired
    private AtestadoTaDao atestadoDao;

  @Override
  public List<AtestadoTa> listarAtestados() {
    return (List<AtestadoTa>) atestadoDao.findAll();
  }

  @Override
  @Transactional
  public void agregarAtestado(AtestadoTa atestado) {
    atestadoDao.save(atestado);
  }

  @Override
  @Transactional
  public void actualizarAtestado(AtestadoTa atestado) {
    AtestadoTa correoExistente = atestadoDao.findById(atestado.getIdAtestadoTa()).orElse(null);
    atestadoDao.save(correoExistente);
  }

  @Override
  public void eliminarAtestado(AtestadoTa atestado) {
    atestadoDao.delete(atestado);
  }

  @Override
  public AtestadoTa encontrarAtestado(AtestadoTa atestado) {
    return atestadoDao.findById(atestado.getIdAtestadoTa()).orElse(null);
  }
}