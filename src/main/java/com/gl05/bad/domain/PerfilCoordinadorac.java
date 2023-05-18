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
@Table(name = "PERFIL_COORDINADORAC")
@NamedQueries({
    @NamedQuery(name = "PerfilCoordinadorac.findAll", query = "SELECT p FROM PerfilCoordinadorac p"),
    @NamedQuery(name = "PerfilCoordinadorac.findByIdResca", query = "SELECT p FROM PerfilCoordinadorac p WHERE p.idResca = :idResca"),
    @NamedQuery(name = "PerfilCoordinadorac.findByTituloRespon", query = "SELECT p FROM PerfilCoordinadorac p WHERE p.tituloRespon = :tituloRespon"),
    @NamedQuery(name = "PerfilCoordinadorac.findByResponsabilidad", query = "SELECT p FROM PerfilCoordinadorac p WHERE p.responsabilidad = :responsabilidad")})
public class PerfilCoordinadorac implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_RESCA")
    private Long idResca;
    @Basic(optional = false)
    @Column(name = "TITULO_RESPON")
    private String tituloRespon;
    @Basic(optional = false)
    private String responsabilidad;
    @JoinColumn(name = "ID_LPC", referencedColumnName = "ID_LPC")
    @ManyToOne
    private ListadoPerfilCoordinadorac idLpc;

    public PerfilCoordinadorac() {
    }

    public PerfilCoordinadorac(Long idResca) {
        this.idResca = idResca;
    }

    public PerfilCoordinadorac(Long idResca, String tituloRespon, String responsabilidad) {
        this.idResca = idResca;
        this.tituloRespon = tituloRespon;
        this.responsabilidad = responsabilidad;
    }

    public Long getIdResca() {
        return idResca;
    }

    public void setIdResca(Long idResca) {
        this.idResca = idResca;
    }

    public String getTituloRespon() {
        return tituloRespon;
    }

    public void setTituloRespon(String tituloRespon) {
        this.tituloRespon = tituloRespon;
    }

    public String getResponsabilidad() {
        return responsabilidad;
    }

    public void setResponsabilidad(String responsabilidad) {
        this.responsabilidad = responsabilidad;
    }

    public ListadoPerfilCoordinadorac getIdLpc() {
        return idLpc;
    }

    public void setIdLpc(ListadoPerfilCoordinadorac idLpc) {
        this.idLpc = idLpc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResca != null ? idResca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilCoordinadorac)) {
            return false;
        }
        PerfilCoordinadorac other = (PerfilCoordinadorac) object;
        if ((this.idResca == null && other.idResca != null) || (this.idResca != null && !this.idResca.equals(other.idResca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.PerfilCoordinadorac[ idResca=" + idResca + " ]";
    }
    
}
