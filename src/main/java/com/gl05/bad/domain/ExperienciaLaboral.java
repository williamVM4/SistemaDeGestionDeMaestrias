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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author william
 */
@Entity
@Table(name = "EXPERIENCIA_LABORAL")
@NamedQueries({
    @NamedQuery(name = "ExperienciaLaboral.findAll", query = "SELECT e FROM ExperienciaLaboral e"),
    @NamedQuery(name = "ExperienciaLaboral.findByIdEl", query = "SELECT e FROM ExperienciaLaboral e WHERE e.idEl = :idEl"),
    @NamedQuery(name = "ExperienciaLaboral.findByNombreInstitucion", query = "SELECT e FROM ExperienciaLaboral e WHERE e.nombreInstitucion = :nombreInstitucion"),
    @NamedQuery(name = "ExperienciaLaboral.findByCargo", query = "SELECT e FROM ExperienciaLaboral e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "ExperienciaLaboral.findByFunciones", query = "SELECT e FROM ExperienciaLaboral e WHERE e.funciones = :funciones"),
    @NamedQuery(name = "ExperienciaLaboral.findByPeriodoInicio", query = "SELECT e FROM ExperienciaLaboral e WHERE e.periodoInicio = :periodoInicio"),
    @NamedQuery(name = "ExperienciaLaboral.findByPeriodoFin", query = "SELECT e FROM ExperienciaLaboral e WHERE e.periodoFin = :periodoFin")})
public class ExperienciaLaboral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_EL")
    private Long idEl;
    @Basic(optional = false)
    @Column(name = "NOMBRE_INSTITUCION")
    private String nombreInstitucion;
    @Basic(optional = false)
    private String cargo;
    @Basic(optional = false)
    private String funciones;
    @Basic(optional = false)
    @Column(name = "PERIODO_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodoInicio;
    @Basic(optional = false)
    @Column(name = "PERIODO_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date periodoFin;
    @JoinColumn(name = "ID_LIST_EL", referencedColumnName = "ID_LIST_EL")
    @ManyToOne(optional = false)
    private ListadoExperienciaLaboral idListEl;

    public ExperienciaLaboral() {
    }

    public ExperienciaLaboral(Long idEl) {
        this.idEl = idEl;
    }

    public ExperienciaLaboral(Long idEl, String nombreInstitucion, String cargo, String funciones, Date periodoInicio, Date periodoFin) {
        this.idEl = idEl;
        this.nombreInstitucion = nombreInstitucion;
        this.cargo = cargo;
        this.funciones = funciones;
        this.periodoInicio = periodoInicio;
        this.periodoFin = periodoFin;
    }

    public Long getIdEl() {
        return idEl;
    }

    public void setIdEl(Long idEl) {
        this.idEl = idEl;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public Date getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(Date periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public Date getPeriodoFin() {
        return periodoFin;
    }

    public void setPeriodoFin(Date periodoFin) {
        this.periodoFin = periodoFin;
    }

    public ListadoExperienciaLaboral getIdListEl() {
        return idListEl;
    }

    public void setIdListEl(ListadoExperienciaLaboral idListEl) {
        this.idListEl = idListEl;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEl != null ? idEl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExperienciaLaboral)) {
            return false;
        }
        ExperienciaLaboral other = (ExperienciaLaboral) object;
        if ((this.idEl == null && other.idEl != null) || (this.idEl != null && !this.idEl.equals(other.idEl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.ExperienciaLaboral[ idEl=" + idEl + " ]";
    }
    
}
