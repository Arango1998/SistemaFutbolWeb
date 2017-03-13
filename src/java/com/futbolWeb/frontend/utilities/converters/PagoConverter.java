/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.utilities.converters;

import com.futbolWeb.backend.persistence.entities.Pago;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Felipe
 */
@FacesConverter(forClass=Pago.class)
public class PagoConverter extends AbstractConverter {

    public PagoConverter() {
   
       this.nameManagedBean = "pagoManagedBean";
    }
    
    
}
