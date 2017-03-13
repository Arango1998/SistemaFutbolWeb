/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.ActividadElectiva;
import com.futbolWeb.backend.persistens.facades.ActividadElectivaFacadeLocal;
import com.futbolWeb.frontend.utilities.converters.InterfaceController;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Felipe
 */
@Named(value = "actividadManageBean")
@RequestScoped
public class ActividadManageBean implements Serializable, InterfaceController<ActividadElectiva> {

     private ActividadElectiva actividad;
     
     @EJB
    private ActividadElectivaFacadeLocal actividadfl;
    public ActividadManageBean() {
    }
    
    @PostConstruct
    public void init (){
    actividad = new ActividadElectiva();
    }
    @Override
    public ActividadElectiva getObjectByKey(Integer key) {
   return actividadfl.find(key);
    }

    public ActividadElectiva getActividad() {
        return actividad;
    }

    public void setActividad(ActividadElectiva actividad) {
        this.actividad = actividad;
    }

    public ActividadElectivaFacadeLocal getActividadfl() {
        return actividadfl;
    }

    public void setActividadfl(ActividadElectivaFacadeLocal actividadfl) {
        this.actividadfl = actividadfl;
    }
    public void registrarActividad(){
    
        try {
            actividadfl.create(actividad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Pago registrado con exito"));
        } catch (Exception e) {
        }
    }
    public void eliminarActividad(){
    try {
            actividadfl.remove(actividad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Pago eliminado con exito"));
        } catch (Exception e) {
        }
        
    }
    public void modificarActividad(){
    
        try {
            actividadfl.edit(actividad);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Pago actualizado con exito"));
        } catch (Exception e) {
        }
        
        
    }
    
    public List<ActividadElectiva> listarActividad (){
    return actividadfl.findAll();
    }
    
}
