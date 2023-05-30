/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author william
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b"),
    @NamedQuery(name = "Bitacora.findByIdBitacora", query = "SELECT b FROM Bitacora b WHERE b.idBitacora = :idBitacora"),
    @NamedQuery(name = "Bitacora.findByNombreEvento", query = "SELECT b FROM Bitacora b WHERE b.nombreEvento = :nombreEvento"),
    @NamedQuery(name = "Bitacora.findByHoraEvento", query = "SELECT b FROM Bitacora b WHERE b.horaEvento = :horaEvento"),
    @NamedQuery(name = "Bitacora.findByIpEquipo", query = "SELECT b FROM Bitacora b WHERE b.ipEquipo = :ipEquipo")})
public class Bitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_BITACORA")
    private Long idBitacora;
    @Basic(optional = false)
    @Column(name = "NOMBRE_EVENTO")
    private String nombreEvento;
    @Basic(optional = false)
    @Column(name = "HORA_EVENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEvento;
    @Basic(optional = false)
    @Column(name = "IP_EQUIPO")
    private String ipEquipo;

    public Bitacora() {
    }

    public Bitacora(Long idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Bitacora(Long idBitacora, String nombreEvento, Date horaEvento, String ipEquipo) {
        this.idBitacora = idBitacora;
        this.nombreEvento = nombreEvento;
        this.horaEvento = horaEvento;
        this.ipEquipo = ipEquipo;
    }

    public Long getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Long idBitacora) {
        this.idBitacora = idBitacora;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Date getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(Date horaEvento) {
        this.horaEvento = horaEvento;
    }

    public String getIpEquipo() {
        return ipEquipo;
    }

    public void setIpEquipo(String ipEquipo) {
        this.ipEquipo = ipEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBitacora != null ? idBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.Bitacora[ idBitacora=" + idBitacora + " ]";
    }
    
}
