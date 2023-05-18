/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl05.bad.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author william
 */
@Entity
@Table(name = "LISTADO_DOCUMENTACION_PERSONAL")
@NamedQueries({
    @NamedQuery(name = "ListadoDocumentacionPersonal.findAll", query = "SELECT l FROM ListadoDocumentacionPersonal l"),
    @NamedQuery(name = "ListadoDocumentacionPersonal.findByIdListDp", query = "SELECT l FROM ListadoDocumentacionPersonal l WHERE l.idListDp = :idListDp")})
public class ListadoDocumentacionPersonal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LIST_DP")
    private Long idListDp;
    @Lob
    @Column(name = "DUI_FILE")
    private Serializable duiFile;
    @Lob
    @Column(name = "NIT_FILE")
    private Serializable nitFile;
    @Lob
    @Column(name = "NUP_FILE")
    private Serializable nupFile;
    @Lob
    @Column(name = "PASAPORTE_FILE")
    private Serializable pasaporteFile;
    @Lob
    @Column(name = "CV_FILE")
    private Serializable cvFile;
    @Lob
    @Column(name = "DOC_PERSONAL_FILE")
    private Serializable docPersonalFile;
    @OneToMany(mappedBy = "idListDp")
    private Collection<AspiranteProfesor> aspiranteProfesorCollection;
    @OneToMany(mappedBy = "idListDp")
    private Collection<CoordinadorAcademico_1> coordinadorAcademicoCollection;

    public ListadoDocumentacionPersonal() {
    }

    public ListadoDocumentacionPersonal(Long idListDp) {
        this.idListDp = idListDp;
    }

    public Long getIdListDp() {
        return idListDp;
    }

    public void setIdListDp(Long idListDp) {
        this.idListDp = idListDp;
    }

    public Serializable getDuiFile() {
        return duiFile;
    }

    public void setDuiFile(Serializable duiFile) {
        this.duiFile = duiFile;
    }

    public Serializable getNitFile() {
        return nitFile;
    }

    public void setNitFile(Serializable nitFile) {
        this.nitFile = nitFile;
    }

    public Serializable getNupFile() {
        return nupFile;
    }

    public void setNupFile(Serializable nupFile) {
        this.nupFile = nupFile;
    }

    public Serializable getPasaporteFile() {
        return pasaporteFile;
    }

    public void setPasaporteFile(Serializable pasaporteFile) {
        this.pasaporteFile = pasaporteFile;
    }

    public Serializable getCvFile() {
        return cvFile;
    }

    public void setCvFile(Serializable cvFile) {
        this.cvFile = cvFile;
    }

    public Serializable getDocPersonalFile() {
        return docPersonalFile;
    }

    public void setDocPersonalFile(Serializable docPersonalFile) {
        this.docPersonalFile = docPersonalFile;
    }

    public Collection<AspiranteProfesor> getAspiranteProfesorCollection() {
        return aspiranteProfesorCollection;
    }

    public void setAspiranteProfesorCollection(Collection<AspiranteProfesor> aspiranteProfesorCollection) {
        this.aspiranteProfesorCollection = aspiranteProfesorCollection;
    }

    public Collection<CoordinadorAcademico_1> getCoordinadorAcademicoCollection() {
        return coordinadorAcademicoCollection;
    }

    public void setCoordinadorAcademicoCollection(Collection<CoordinadorAcademico_1> coordinadorAcademicoCollection) {
        this.coordinadorAcademicoCollection = coordinadorAcademicoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListDp != null ? idListDp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListadoDocumentacionPersonal)) {
            return false;
        }
        ListadoDocumentacionPersonal other = (ListadoDocumentacionPersonal) object;
        if ((this.idListDp == null && other.idListDp != null) || (this.idListDp != null && !this.idListDp.equals(other.idListDp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gl05.bad.domain.ListadoDocumentacionPersonal[ idListDp=" + idListDp + " ]";
    }
    
}
