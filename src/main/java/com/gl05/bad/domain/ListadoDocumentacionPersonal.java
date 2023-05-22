package com.gl05.bad.domain;

import java.io.Serializable;
import java.sql.Blob;
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
import lombok.Data;

@Data
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
    private Blob duiFile;
    
    @Lob
    @Column(name = "NIT_FILE")
    private Blob nitFile;
    
    @Lob
    @Column(name = "NUP_FILE")
    private Blob nupFile;
    
    @Lob
    @Column(name = "PASAPORTE_FILE")
    private Blob pasaporteFile;
    
    @Lob
    @Column(name = "CV_FILE")
    private Blob cvFile;
    
    @Lob
    @Column(name = "DOC_PERSONAL_FILE")
    private Blob docPersonalFile;
    
    @OneToMany(mappedBy = "idListDp")
    private Collection<AspiranteProfesor> aspiranteProfesorCollection;
    
    @OneToMany(mappedBy = "idListDp")
    private Collection<CoordinadorAcademico> coordinadorAcademicoCollection;

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
