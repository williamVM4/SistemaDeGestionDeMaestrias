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
    private Integer idMaestria;
    
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

    public Maestria(Integer idMaestria) {
        this.idMaestria = idMaestria;
    }

    public Maestria(Integer idMaestria, String nombreMaestria) {
        this.idMaestria = idMaestria;
        this.nombreMaestria = nombreMaestria;
    }

    public Integer getIdMaestria() {
        return idMaestria;
    }

    public void setIdMaestria(Integer idMaestria) {
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
        return "Maestria[ idMaestria=" + idMaestria + " ]";
    }
    
}
