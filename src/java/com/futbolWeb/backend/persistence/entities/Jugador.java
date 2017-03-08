/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.backend.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian Suesca
 */
@Entity
@Table(name = "jugadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
    @NamedQuery(name = "Jugador.findByIdUsuario", query = "SELECT j FROM Jugador j WHERE j.idUsuario = :idUsuario"),
    @NamedQuery(name = "Jugador.findByPosicion", query = "SELECT j FROM Jugador j WHERE j.posicion = :posicion")})
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "posicion")
    private String posicion;
    @JoinTable(name = "jugadores_actividades", joinColumns = {
        @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_id_actividad", referencedColumnName = "id_actividad")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<ActividadElectiva> actividadElectivaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUsuarioJugador", fetch = FetchType.EAGER)
    private List<Seguimiento> seguimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.EAGER)
    private List<SeguimientoEncuentro> seguimientoEncuentroList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "documento", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;
    @JoinColumn(name = "fk_id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Equipo fkIdEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdJugador", fetch = FetchType.EAGER)
    private List<Pago> pagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.EAGER)
    private List<PosicionSeguimiento> posicionSeguimientoList;

    public Jugador() {
    }

    public Jugador(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Jugador(Long idUsuario, String posicion) {
        this.idUsuario = idUsuario;
        this.posicion = posicion;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    @XmlTransient
    public List<ActividadElectiva> getActividadElectivaList() {
        return actividadElectivaList;
    }

    public void setActividadElectivaList(List<ActividadElectiva> actividadElectivaList) {
        this.actividadElectivaList = actividadElectivaList;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    @XmlTransient
    public List<SeguimientoEncuentro> getSeguimientoEncuentroList() {
        return seguimientoEncuentroList;
    }

    public void setSeguimientoEncuentroList(List<SeguimientoEncuentro> seguimientoEncuentroList) {
        this.seguimientoEncuentroList = seguimientoEncuentroList;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Equipo getFkIdEquipo() {
        return fkIdEquipo;
    }

    public void setFkIdEquipo(Equipo fkIdEquipo) {
        this.fkIdEquipo = fkIdEquipo;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @XmlTransient
    public List<PosicionSeguimiento> getPosicionSeguimientoList() {
        return posicionSeguimientoList;
    }

    public void setPosicionSeguimientoList(List<PosicionSeguimiento> posicionSeguimientoList) {
        this.posicionSeguimientoList = posicionSeguimientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futbolWeb.backend.persistence.entities.Jugador[ idUsuario=" + idUsuario + " ]";
    }
    
}
