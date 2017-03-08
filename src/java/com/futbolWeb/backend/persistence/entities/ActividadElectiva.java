/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.backend.persistence.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian Suesca
 */
@Entity
@Table(name = "actividades_electivas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActividadElectiva.findAll", query = "SELECT a FROM ActividadElectiva a"),
    @NamedQuery(name = "ActividadElectiva.findByIdActividad", query = "SELECT a FROM ActividadElectiva a WHERE a.idActividad = :idActividad"),
    @NamedQuery(name = "ActividadElectiva.findByNombreActividad", query = "SELECT a FROM ActividadElectiva a WHERE a.nombreActividad = :nombreActividad"),
    @NamedQuery(name = "ActividadElectiva.findByHoraInicio", query = "SELECT a FROM ActividadElectiva a WHERE a.horaInicio = :horaInicio"),
    @NamedQuery(name = "ActividadElectiva.findByHoraFin", query = "SELECT a FROM ActividadElectiva a WHERE a.horaFin = :horaFin"),
    @NamedQuery(name = "ActividadElectiva.findByFkIdUsuario", query = "SELECT a FROM ActividadElectiva a WHERE a.fkIdUsuario = :fkIdUsuario")})
public class ActividadElectiva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_actividad")
    private Integer idActividad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_actividad")
    private String nombreActividad;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "descripcion_actividad")
    private String descripcionActividad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fk_id_usuario")
    private long fkIdUsuario;
    @ManyToMany(mappedBy = "actividadElectivaList", fetch = FetchType.EAGER)
    private List<Jugador> jugadorList;

    public ActividadElectiva() {
    }

    public ActividadElectiva(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public ActividadElectiva(Integer idActividad, String nombreActividad, String descripcionActividad, Date horaInicio, Date horaFin, long fkIdUsuario) {
        this.idActividad = idActividad;
        this.nombreActividad = nombreActividad;
        this.descripcionActividad = descripcionActividad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.fkIdUsuario = fkIdUsuario;
    }

    public Integer getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(Integer idActividad) {
        this.idActividad = idActividad;
    }

    public String getNombreActividad() {
        return nombreActividad;
    }

    public void setNombreActividad(String nombreActividad) {
        this.nombreActividad = nombreActividad;
    }

    public String getDescripcionActividad() {
        return descripcionActividad;
    }

    public void setDescripcionActividad(String descripcionActividad) {
        this.descripcionActividad = descripcionActividad;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public long getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(long fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @XmlTransient
    public List<Jugador> getJugadorList() {
        return jugadorList;
    }

    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActividad != null ? idActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActividadElectiva)) {
            return false;
        }
        ActividadElectiva other = (ActividadElectiva) object;
        if ((this.idActividad == null && other.idActividad != null) || (this.idActividad != null && !this.idActividad.equals(other.idActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futbolWeb.backend.persistence.entities.ActividadElectiva[ idActividad=" + idActividad + " ]";
    }
    
}
