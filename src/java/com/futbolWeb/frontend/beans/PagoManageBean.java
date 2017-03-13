/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.beans;

import com.futbolWeb.backend.persistence.entities.Pago;
import com.futbolWeb.backend.persistens.facades.PagoFacadeLocal;
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
@Named(value = "pagoManageBean")
@RequestScoped
public class PagoManageBean implements Serializable, InterfaceController<Pago> {

    private Pago pago;
    @EJB
    private PagoFacadeLocal pagofl;
    
    public PagoManageBean() {
    }

    @PostConstruct
    public void init(){
    pago = new Pago();
    }
    
    @Override
    public Pago getObjectByKey(Integer key) {
   return pagofl.find(key);
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    public PagoFacadeLocal getPagofl() {
        return pagofl;
    }

    public void setPagofl(PagoFacadeLocal pagofl) {
        this.pagofl = pagofl;
    }
    
    public void registrarPago(){
    
        try {
            pagofl.create(pago);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Pago registrado con exito"));
        } catch (Exception e) {
        }
    }
    public void eliminarPago(){
    try {
            pagofl.remove(pago);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Pago eliminado con exito"));
        } catch (Exception e) {
        }
        
    }
    public void modificarPago(){
    
        try {
            pagofl.edit(pago);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"","Pago actualizado con exito"));
        } catch (Exception e) {
        }
        
        
    }
    
    public List<Pago> listarPago (){
    return pagofl.findAll();
    }
    
}
