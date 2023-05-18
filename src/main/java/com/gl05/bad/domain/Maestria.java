/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author william
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Maestria.findAll", query = "SELECT m FROM Maestria m"),
    @NamedQuery(name = "Maestria.findByIdMaestria", query = "SELECT m FROM Maestria m WHERE m.idMaestria = :idMaestria"),
    @NamedQuery(name = "Maestria.findByNombreMaestria", query = "SELECT m FROM Maestria m WHERE m.nombreMaestria = :nombreMaestria")})
public class Maestria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_MAESTRIA")
    private Long idMaestria;
    @Basic(optional = false)
    @Column(name = "NOMBRE_MAESTRIA")
    private String nombreMaestria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaestria")
    private Collection<PlanEstudio> planEstudioCollection;
    @JoinColumn(name = "ID_COOR_ACA", referencedColumnName = "ID_COOR_ACA")
    @ManyToOne(optional = false)
    private CoordinadorAcademico_1 idCoorAca;
    @JoinColumn(name = "ID_POSTGRADO", referencedColumnName = "ID_POSTGRADO")
    @ManyToOne(optional = false)
    private EscuelaPostgrado idPostgrado;
    @JoinColumn(name = "ID_LIST_COHORTE", referencedColumnName = "ID_LIST_COHORTE")
    @ManyToOne
    private ListadoCohorte idListCohorte;
    @JoinColumn(name = "ID_LPA", referencedColumnName = "ID_LPA")
    @ManyToOne
    private ListadoPerfilAspirante idLpa;
    @JoinColumn(name = "ID_LPC", referencedColumnName = "ID_LPC")
    @ManyToOne
    private ListadoPerfilCoordinadorac idLpc;

    public Maestria() {
    }

    public Maestria(Long idMaestria) {
        this.idMaestria = idMaestria;
    }

    public Maestria(Long idMaestria, String nombreMaestria) {
        this.idMaestria = idMaestria;
        this.nombreMaestria = nombreMaestria;
    }

    public Long getIdMaestria() {
        return idMaestria;
    }

    public void setIdMaestria(Long idMaestria) {
        this.idMaestria = idMaestria;
    }

    public String getNombreMaestria() {
        return nombreMaestria;
    }

    public void setNombreMaestria(String nombreMaestria) {
        this.nombreMaestria = nombreMaestria;
    }

    public Collection<PlanEstudio> getPlanEstudioCollection() {
        return planEstudioCollection;
    }

    public void setPlanEstudioCollection(Collection<PlanEstudio> planEstudioCollection) {
        this.planEstudioCollection = planEstudioCollection;
    }

    public CoordinadorAcademico_1 getIdCoorAca() {
        return idCoorAca;
    }

    public void setIdCoorAca(CoordinadorAcademico_1 idCoorAca) {
        this.idCoorAca = idCoorAca;
    }

    public EscuelaPostgrado getIdPostgrado() {
        return idPostgrado;
    }

    public void setIdPostgrado(EscuelaPostgrado idPostgrado) {
        this.idPostgrado = idPostgrado;
    }

    public ListadoCohorte getIdListCohorte() {
        return idListCohorte;
    }

    public void setIdListCohorte(ListadoCohorte idListCohorte) {
        this.idListCohorte = idListCohorte;
    }

    public ListadoPerfilAspirante getIdLpa() {
        return idLpa;
    }

    public void setIdLpa(ListadoPerfilAspirante idLpa) {
        this.idLpa = idLpa;
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
        hash += (idMaestria != null ? idMaestria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maestria)) {
            return false;
        }
        Maestria other = (Maestria) object;
        if ((this.idMaestria == null && other.idMaestria != null) || (this.idMaestria != null && !this.idMaestria.equals(other.idMaestria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.Maestria[ idMaestria=" + idMaestria + " ]";
    }
    
}
