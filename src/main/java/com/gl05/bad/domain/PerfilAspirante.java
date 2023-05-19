package com.gl05.bad.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "PERFIL_ASPIRANTE")
@NamedQueries({
    @NamedQuery(name = "PerfilAspirante.findAll", query = "SELECT p FROM PerfilAspirante p"),
    @NamedQuery(name = "PerfilAspirante.findByIdPerfilAspirante", query = "SELECT p FROM PerfilAspirante p WHERE p.idPerfilAspirante = :idPerfilAspirante"),
    @NamedQuery(name = "PerfilAspirante.findByTituloReq", query = "SELECT p FROM PerfilAspirante p WHERE p.tituloReq = :tituloReq"),
    @NamedQuery(name = "PerfilAspirante.findByRequisitos", query = "SELECT p FROM PerfilAspirante p WHERE p.requisitos = :requisitos")})
public class PerfilAspirante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "S_PERFIL_ASPIRANTE", sequenceName = "S_PERFIL_ASPIRANTE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_PERFIL_ASPIRANTE")
    @Column(name = "ID_PERFIL_ASPIRANTE")
    private int idPerfilAspirante;
    @Basic(optional = false)
    @Column(name = "TITULO_REQ")
    private String tituloReq;
    @Basic(optional = false)
    private String requisitos;
    @JoinColumn(name = "ID_LPA", referencedColumnName = "ID_LPA")
    @ManyToOne
    private ListadoPerfilAspirante idLpa;

    public PerfilAspirante() {
    }

    public PerfilAspirante(int idPerfilAspirante) {
        this.idPerfilAspirante = idPerfilAspirante;
    }

    public PerfilAspirante(int idPerfilAspirante, String tituloReq, String requisitos) {
        this.idPerfilAspirante = idPerfilAspirante;
        this.tituloReq = tituloReq;
        this.requisitos = requisitos;
    }

    public int getIdPerfilAspirante() {
        return idPerfilAspirante;
    }

    public void setIdPerfilAspirante(int idPerfilAspirante) {
        this.idPerfilAspirante = idPerfilAspirante;
    }

    public String getTituloReq() {
        return tituloReq;
    }

    public void setTituloReq(String tituloReq) {
        this.tituloReq = tituloReq;
    }

    public String getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    public ListadoPerfilAspirante getIdLpa() {
        return idLpa;
    }

    public void setIdLpa(ListadoPerfilAspirante idLpa) {
        this.idLpa = idLpa;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + idPerfilAspirante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        PerfilAspirante other = (PerfilAspirante) object;
        return idPerfilAspirante == other.idPerfilAspirante;
    }
    
    @Override
    public String toString() {
        return "PerfilAspirante[ idPerfilAspirante=" + idPerfilAspirante + " ]";
    }
    
}
