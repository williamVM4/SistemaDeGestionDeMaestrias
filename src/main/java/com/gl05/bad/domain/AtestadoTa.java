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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author william
 */
@Entity
@Table(name = "ATESTADO_TA")
@NamedQueries({
    @NamedQuery(name = "AtestadoTa.findAll", query = "SELECT a FROM AtestadoTa a"),
    @NamedQuery(name = "AtestadoTa.findByIdAtestadoTa", query = "SELECT a FROM AtestadoTa a WHERE a.idAtestadoTa = :idAtestadoTa"),
    @NamedQuery(name = "AtestadoTa.findByNombreAta", query = "SELECT a FROM AtestadoTa a WHERE a.nombreAta = :nombreAta"),
    @NamedQuery(name = "AtestadoTa.findByTipoAta", query = "SELECT a FROM AtestadoTa a WHERE a.tipoAta = :tipoAta"),
    @NamedQuery(name = "AtestadoTa.findByInstitucion", query = "SELECT a FROM AtestadoTa a WHERE a.institucion = :institucion"),
    @NamedQuery(name = "AtestadoTa.findByAnioTitulacion", query = "SELECT a FROM AtestadoTa a WHERE a.anioTitulacion = :anioTitulacion")})
public class AtestadoTa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ATESTADO_TA")
    private Long idAtestadoTa;
    @Basic(optional = false)
    @Column(name = "NOMBRE_ATA")
    private String nombreAta;
    @Basic(optional = false)
    @Column(name = "TIPO_ATA")
    private String tipoAta;
    @Basic(optional = false)
    private String institucion;
    @Basic(optional = false)
    @Lob
    @Column(name = "ARCHIVO_ATA")
    private Serializable archivoAta;
    @Basic(optional = false)
    @Column(name = "ANIO_TITULACION")
    private short anioTitulacion;
    @JoinColumn(name = "ID_LIST_TA", referencedColumnName = "ID_LIST_TA")
    @ManyToOne(optional = false)
    private ListadoTitulosAcademicos idListTa;

    public AtestadoTa() {
    }

    public AtestadoTa(Long idAtestadoTa) {
        this.idAtestadoTa = idAtestadoTa;
    }

    public AtestadoTa(Long idAtestadoTa, String nombreAta, String tipoAta, String institucion, Serializable archivoAta, short anioTitulacion) {
        this.idAtestadoTa = idAtestadoTa;
        this.nombreAta = nombreAta;
        this.tipoAta = tipoAta;
        this.institucion = institucion;
        this.archivoAta = archivoAta;
        this.anioTitulacion = anioTitulacion;
    }

    public Long getIdAtestadoTa() {
        return idAtestadoTa;
    }

    public void setIdAtestadoTa(Long idAtestadoTa) {
        this.idAtestadoTa = idAtestadoTa;
    }

    public String getNombreAta() {
        return nombreAta;
    }

    public void setNombreAta(String nombreAta) {
        this.nombreAta = nombreAta;
    }

    public String getTipoAta() {
        return tipoAta;
    }

    public void setTipoAta(String tipoAta) {
        this.tipoAta = tipoAta;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public Serializable getArchivoAta() {
        return archivoAta;
    }

    public void setArchivoAta(Serializable archivoAta) {
        this.archivoAta = archivoAta;
    }

    public short getAnioTitulacion() {
        return anioTitulacion;
    }

    public void setAnioTitulacion(short anioTitulacion) {
        this.anioTitulacion = anioTitulacion;
    }

    public ListadoTitulosAcademicos getIdListTa() {
        return idListTa;
    }

    public void setIdListTa(ListadoTitulosAcademicos idListTa) {
        this.idListTa = idListTa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAtestadoTa != null ? idAtestadoTa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AtestadoTa)) {
            return false;
        }
        AtestadoTa other = (AtestadoTa) object;
        if ((this.idAtestadoTa == null && other.idAtestadoTa != null) || (this.idAtestadoTa != null && !this.idAtestadoTa.equals(other.idAtestadoTa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.AtestadoTa[ idAtestadoTa=" + idAtestadoTa + " ]";
    }
    
}
