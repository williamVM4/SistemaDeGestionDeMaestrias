package com.gl05.bad.domain;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="COORDINADOR_ACADEMICO")
public class CoordinadorAcademico implements Serializable{
  private static final long serialVersionUID = 1L;
  
  @Column(name="ID_COOR_ACA")
  @Id
  @SequenceGenerator(name = "S_COORDINADOR_ACADEMICO", sequenceName = "S_COORDINADOR_ACADEMICO", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_COORDINADOR_ACADEMICO")
    private int idCA;
 
  @Column(name="IDUSUARIO", nullable = true)
    private Integer idUsuario;
  
  @Column(name="COD_CA", nullable = true)
    private String codCA;
  
  @Column(name="NOMBRES_CA", nullable = true)
    private String nombresCA;
  
  @Column(name="APELLIDOS_CA", nullable = true)
    private String apellidosCA;
  
  @Column(name="SEXO_CA", nullable = true)
    private String sexoCA;
  
  @Column(name="GENERO_CA", nullable = true)
    private String generoCA;
  
  @Column(name="FECHA_NAC_CA", nullable = true)
    private Date fechaNacCA;  

  @Column(name="ESTADO_CIVIL_CA", nullable = true)
    private String estadoCivilCA;
  
  @Column(name="NACIONALIDAD_CA", nullable = true)
    private String nacionalidadCA;
   
  @Column(name="ID_PAIS", nullable = true)
    private Integer idPais;

  @Column(name="FOTOGRAFIA_CA", nullable = true)
    private Blob fotografia;
  
  @Column(name="DUI_CA", nullable = true)
    private String duiCA;
  
  @Column(name="NIT_CA", nullable = true)
    private String nitCA;
  
  @Column(name="NUP_CA", nullable = true)
    private String nupCA;
  
  @Column(name="PASAPORTE_CA", nullable = true)
    private String pasaporteCA;
  
  @Column(name="DOC_PERSONAL_CA", nullable = true)
    private String docPersonalCA;

    @Column(name="ID_LIST_TELEFONO", nullable = true)
    private Integer idListTelefono;
  
  @Column(name="ID_LIST_DP", nullable = true)
    private Integer idListDP;

   @Column(name="ID_LIST_TA", nullable = true)
    private Integer idListTA;

   @Column(name="ID_LIST_CORREO", nullable = true)
    private Integer idListCorreo;
  
}
