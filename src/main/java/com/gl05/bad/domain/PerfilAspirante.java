/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl05.bad.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author william
 */
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
    @Basic(optional = false)
    @Column(name = "ID_PERFIL_ASPIRANTE")
    private Long idPerfilAspirante;
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

    public PerfilAspirante(Long idPerfilAspirante) {
        this.idPerfilAspirante = idPerfilAspirante;
    }

    public PerfilAspirante(Long idPerfilAspirante, String tituloReq, String requisitos) {
        this.idPerfilAspirante = idPerfilAspirante;
        this.tituloReq = tituloReq;
        this.requisitos = requisitos;
    }

    public Long getIdPerfilAspirante() {
        return idPerfilAspirante;
    }

    public void setIdPerfilAspirante(Long idPerfilAspirante) {
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
        int hash = 0;
        hash += (idPerfilAspirante != null ? idPerfilAspirante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilAspirante)) {
            return false;
        }
        PerfilAspirante other = (PerfilAspirante) object;
        if ((this.idPerfilAspirante == null && other.idPerfilAspirante != null) || (this.idPerfilAspirante != null && !this.idPerfilAspirante.equals(other.idPerfilAspirante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.PerfilAspirante[ idPerfilAspirante=" + idPerfilAspirante + " ]";
    }
    
}
