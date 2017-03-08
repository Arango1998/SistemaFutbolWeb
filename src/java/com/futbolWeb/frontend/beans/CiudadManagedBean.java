/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Ciudad;
import com.futbolWeb.backend.persistens.facades.CiudadFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Cristian Suesca
 */
@Named(value = "ciudadManagedBean")
@RequestScoped
public class CiudadManagedBean implements Serializable {

    private Ciudad ciudad;
    @EJB
    private CiudadFacadeLocal ciudadfl;

    public CiudadManagedBean() {
    }

    @PostConstruct
    public void init() {

        ciudad = new Ciudad();

    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void registrarCiudad() {

        try {

            ciudadfl.create(ciudad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Ciudad registrada con éxito"));

        } catch (Exception e) {

        }
    }

}
