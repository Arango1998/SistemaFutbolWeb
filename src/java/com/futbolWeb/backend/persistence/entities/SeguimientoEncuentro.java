/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.backend.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Suesca
 */
@Entity
@Table(name = "seguimientos_encuentros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeguimientoEncuentro.findAll", query = "SELECT s FROM SeguimientoEncuentro s"),
    @NamedQuery(name = "SeguimientoEncuentro.findByIdSeguimientoEncuentro", query = "SELECT s FROM SeguimientoEncuentro s WHERE s.idSeguimientoEncuentro = :idSeguimientoEncuentro"),
    @NamedQuery(name = "SeguimientoEncuentro.findByCalificacion", query = "SELECT s FROM SeguimientoEncuentro s WHERE s.calificacion = :calificacion")})
public class SeguimientoEncuentro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_seguimiento_encuentro")
    private Integer idSeguimientoEncuentro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calificacion")
    private int calificacion;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jugador idJugador;
    @JoinColumn(name = "id_entrenador", referencedColumnName = "documento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario idEntrenador;
    @JoinColumn(name = "id_encuentro", referencedColumnName = "id_encuentro")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private EncuentroTorneo idEncuentro;

    public SeguimientoEncuentro() {
    }

    public SeguimientoEncuentro(Integer idSeguimientoEncuentro) {
        this.idSeguimientoEncuentro = idSeguimientoEncuentro;
    }

    public SeguimientoEncuentro(Integer idSeguimientoEncuentro, String observacion, int calificacion) {
        this.idSeguimientoEncuentro = idSeguimientoEncuentro;
        this.observacion = observacion;
        this.calificacion = calificacion;
    }

    public Integer getIdSeguimientoEncuentro() {
        return idSeguimientoEncuentro;
    }

    public void setIdSeguimientoEncuentro(Integer idSeguimientoEncuentro) {
        this.idSeguimientoEncuentro = idSeguimientoEncuentro;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    public Usuario getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(Usuario idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public EncuentroTorneo getIdEncuentro() {
        return idEncuentro;
    }

    public void setIdEncuentro(EncuentroTorneo idEncuentro) {
        this.idEncuentro = idEncuentro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSeguimientoEncuentro != null ? idSeguimientoEncuentro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeguimientoEncuentro)) {
            return false;
        }
        SeguimientoEncuentro other = (SeguimientoEncuentro) object;
        if ((this.idSeguimientoEncuentro == null && other.idSeguimientoEncuentro != null) || (this.idSeguimientoEncuentro != null && !this.idSeguimientoEncuentro.equals(other.idSeguimientoEncuentro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futbolWeb.backend.persistence.entities.SeguimientoEncuentro[ idSeguimientoEncuentro=" + idSeguimientoEncuentro + " ]";
    }
    
}
