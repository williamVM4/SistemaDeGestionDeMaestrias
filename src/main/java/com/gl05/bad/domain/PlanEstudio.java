/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl05.bad.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author william
 */
@Entity
@Table(name = "PLAN_ESTUDIO")
@NamedQueries({
    @NamedQuery(name = "PlanEstudio.findAll", query = "SELECT p FROM PlanEstudio p"),
    @NamedQuery(name = "PlanEstudio.findByIdPlanEstudio", query = "SELECT p FROM PlanEstudio p WHERE p.idPlanEstudio = :idPlanEstudio"),
    @NamedQuery(name = "PlanEstudio.findByCodPlan", query = "SELECT p FROM PlanEstudio p WHERE p.codPlan = :codPlan"),
    @NamedQuery(name = "PlanEstudio.findByModalidad", query = "SELECT p FROM PlanEstudio p WHERE p.modalidad = :modalidad"),
    @NamedQuery(name = "PlanEstudio.findByCumMinimo", query = "SELECT p FROM PlanEstudio p WHERE p.cumMinimo = :cumMinimo"),
    @NamedQuery(name = "PlanEstudio.findByNotaMinimaAprobacion", query = "SELECT p FROM PlanEstudio p WHERE p.notaMinimaAprobacion = :notaMinimaAprobacion"),
    @NamedQuery(name = "PlanEstudio.findByTotalAsignaturas", query = "SELECT p FROM PlanEstudio p WHERE p.totalAsignaturas = :totalAsignaturas"),
    @NamedQuery(name = "PlanEstudio.findByTotalUv", query = "SELECT p FROM PlanEstudio p WHERE p.totalUv = :totalUv"),
    @NamedQuery(name = "PlanEstudio.findByDuracionCarrera", query = "SELECT p FROM PlanEstudio p WHERE p.duracionCarrera = :duracionCarrera"),
    @NamedQuery(name = "PlanEstudio.findByTituloOrtorgar", query = "SELECT p FROM PlanEstudio p WHERE p.tituloOrtorgar = :tituloOrtorgar"),
    @NamedQuery(name = "PlanEstudio.findByAnio", query = "SELECT p FROM PlanEstudio p WHERE p.anio = :anio"),
    @NamedQuery(name = "PlanEstudio.findByPlanEstado", query = "SELECT p FROM PlanEstudio p WHERE p.planEstado = :planEstado")})
public class PlanEstudio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PLAN_ESTUDIO")
    private Long idPlanEstudio;
    @Basic(optional = false)
    @Column(name = "COD_PLAN")
    private String codPlan;
    @Basic(optional = false)
    private String modalidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CUM_MINIMO")
    private BigDecimal cumMinimo;
    @Basic(optional = false)
    @Column(name = "NOTA_MINIMA_APROBACION")
    private BigDecimal notaMinimaAprobacion;
    @Basic(optional = false)
    @Column(name = "TOTAL_ASIGNATURAS")
    private short totalAsignaturas;
    @Basic(optional = false)
    @Column(name = "TOTAL_UV")
    private short totalUv;
    @Basic(optional = false)
    @Column(name = "DURACION_CARRERA")
    private short duracionCarrera;
    @Basic(optional = false)
    @Column(name = "TITULO_ORTORGAR")
    private String tituloOrtorgar;
    @Basic(optional = false)
    private short anio;
    @Basic(optional = false)
    @Column(name = "PLAN_ESTADO")
    private short planEstado;
    @OneToMany(mappedBy = "idPlanEstudio")
    private Collection<MallaCurricular> mallaCurricularCollection;
    @JoinColumn(name = "ID_MAESTRIA", referencedColumnName = "ID_MAESTRIA")
    @ManyToOne(optional = false)
    private Maestria idMaestria;

    public PlanEstudio() {
    }

    public PlanEstudio(Long idPlanEstudio) {
        this.idPlanEstudio = idPlanEstudio;
    }

    public PlanEstudio(Long idPlanEstudio, String codPlan, String modalidad, BigDecimal cumMinimo, BigDecimal notaMinimaAprobacion, short totalAsignaturas, short totalUv, short duracionCarrera, String tituloOrtorgar, short anio, short planEstado) {
        this.idPlanEstudio = idPlanEstudio;
        this.codPlan = codPlan;
        this.modalidad = modalidad;
        this.cumMinimo = cumMinimo;
        this.notaMinimaAprobacion = notaMinimaAprobacion;
        this.totalAsignaturas = totalAsignaturas;
        this.totalUv = totalUv;
        this.duracionCarrera = duracionCarrera;
        this.tituloOrtorgar = tituloOrtorgar;
        this.anio = anio;
        this.planEstado = planEstado;
    }

    public Long getIdPlanEstudio() {
        return idPlanEstudio;
    }

    public void setIdPlanEstudio(Long idPlanEstudio) {
        this.idPlanEstudio = idPlanEstudio;
    }

    public String getCodPlan() {
        return codPlan;
    }

    public void setCodPlan(String codPlan) {
        this.codPlan = codPlan;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public BigDecimal getCumMinimo() {
        return cumMinimo;
    }

    public void setCumMinimo(BigDecimal cumMinimo) {
        this.cumMinimo = cumMinimo;
    }

    public BigDecimal getNotaMinimaAprobacion() {
        return notaMinimaAprobacion;
    }

    public void setNotaMinimaAprobacion(BigDecimal notaMinimaAprobacion) {
        this.notaMinimaAprobacion = notaMinimaAprobacion;
    }

    public short getTotalAsignaturas() {
        return totalAsignaturas;
    }

    public void setTotalAsignaturas(short totalAsignaturas) {
        this.totalAsignaturas = totalAsignaturas;
    }

    public short getTotalUv() {
        return totalUv;
    }

    public void setTotalUv(short totalUv) {
        this.totalUv = totalUv;
    }

    public short getDuracionCarrera() {
        return duracionCarrera;
    }

    public void setDuracionCarrera(short duracionCarrera) {
        this.duracionCarrera = duracionCarrera;
    }

    public String getTituloOrtorgar() {
        return tituloOrtorgar;
    }

    public void setTituloOrtorgar(String tituloOrtorgar) {
        this.tituloOrtorgar = tituloOrtorgar;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public short getPlanEstado() {
        return planEstado;
    }

    public void setPlanEstado(short planEstado) {
        this.planEstado = planEstado;
    }

    public Collection<MallaCurricular> getMallaCurricularCollection() {
        return mallaCurricularCollection;
    }

    public void setMallaCurricularCollection(Collection<MallaCurricular> mallaCurricularCollection) {
        this.mallaCurricularCollection = mallaCurricularCollection;
    }

    public Maestria getIdMaestria() {
        return idMaestria;
    }

    public void setIdMaestria(Maestria idMaestria) {
        this.idMaestria = idMaestria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPlanEstudio != null ? idPlanEstudio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlanEstudio)) {
            return false;
        }
        PlanEstudio other = (PlanEstudio) object;
        if ((this.idPlanEstudio == null && other.idPlanEstudio != null) || (this.idPlanEstudio != null && !this.idPlanEstudio.equals(other.idPlanEstudio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.PlanEstudio[ idPlanEstudio=" + idPlanEstudio + " ]";
    }
    
}
