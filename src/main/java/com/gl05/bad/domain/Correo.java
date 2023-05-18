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

/**
 *
 * @author william
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Correo.findAll", query = "SELECT c FROM Correo c"),
    @NamedQuery(name = "Correo.findByIdCorreo", query = "SELECT c FROM Correo c WHERE c.idCorreo = :idCorreo"),
    @NamedQuery(name = "Correo.findByTipoCorreo", query = "SELECT c FROM Correo c WHERE c.tipoCorreo = :tipoCorreo"),
    @NamedQuery(name = "Correo.findByCorreo", query = "SELECT c FROM Correo c WHERE c.correo = :correo")})
public class Correo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CORREO")
    private Long idCorreo;
    @Basic(optional = false)
    @Column(name = "TIPO_CORREO")
    private String tipoCorreo;
    @Basic(optional = false)
    private String correo;
    @JoinColumn(name = "ID_LIST_CORREO", referencedColumnName = "ID_LIST_CORREO")
    @ManyToOne(optional = false)
    private ListadoCorreo idListCorreo;

    public Correo() {
    }

    public Correo(Long idCorreo) {
        this.idCorreo = idCorreo;
    }

    public Correo(Long idCorreo, String tipoCorreo, String correo) {
        this.idCorreo = idCorreo;
        this.tipoCorreo = tipoCorreo;
        this.correo = correo;
    }

    public Long getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(Long idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getTipoCorreo() {
        return tipoCorreo;
    }

    public void setTipoCorreo(String tipoCorreo) {
        this.tipoCorreo = tipoCorreo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ListadoCorreo getIdListCorreo() {
        return idListCorreo;
    }

    public void setIdListCorreo(ListadoCorreo idListCorreo) {
        this.idListCorreo = idListCorreo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorreo != null ? idCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Correo)) {
            return false;
        }
        Correo other = (Correo) object;
        if ((this.idCorreo == null && other.idCorreo != null) || (this.idCorreo != null && !this.idCorreo.equals(other.idCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.Correo[ idCorreo=" + idCorreo + " ]";
    }
    
}
