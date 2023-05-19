package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = "Maestria.findAll", query = "SELECT m FROM Maestria m"),
    @NamedQuery(name = "Maestria.findByIdMaestria", query = "SELECT m FROM Maestria m WHERE m.idMaestria = :idMaestria"),
    @NamedQuery(name = "Maestria.findByNombreMaestria", query = "SELECT m FROM Maestria m WHERE m.nombreMaestria = :nombreMaestria")})
public class Maestria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "S_MAESTRIA", sequenceName = "S_MAESTRIA", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_MAESTRIA")
    @Column(name = "ID_MAESTRIA")
    private int idMaestria;
    
    @Basic(optional = false)
    @Column(name = "NOMBRE_MAESTRIA")
    private String nombreMaestria;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMaestria")
    private Collection<PlanEstudio> planEstudioCollection;
    
    @JoinColumn(name = "ID_COOR_ACA", referencedColumnName = "ID_COOR_ACA")
    @ManyToOne(optional = false)
    private CoordinadorAcademico idCoorAca;
    
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

    public Maestria(int idMaestria) {
        this.idMaestria = idMaestria;
    }

    public Maestria(int idMaestria, String nombreMaestria) {
        this.idMaestria = idMaestria;
        this.nombreMaestria = nombreMaestria;
    }

    public int getIdMaestria() {
        return idMaestria;
    }

    public void setIdMaestria(int idMaestria) {
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

    public CoordinadorAcademico getIdCoorAca() {
        return idCoorAca;
    }

    public void setIdCoorAca(CoordinadorAcademico idCoorAca) {
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
        final int prime = 31;
        int hash = 1;
        hash = prime * hash + idMaestria;
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
        Maestria other = (Maestria) object;
        return idMaestria == other.idMaestria;
    }

    @Override
    public String toString() {
        return "Maestria[ idMaestria=" + idMaestria + " ]";
    }
    
}
