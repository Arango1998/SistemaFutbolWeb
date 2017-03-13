/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.frontend.utilities.converters;

import com.futbolWeb.backend.persistence.entities.ActividadElectiva;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Felipe
 */
@FacesConverter(forClass=ActividadElectiva.class)
public class ActividadConverter extends AbstractConverter {

    public ActividadConverter() {
    
        this.nameManagedBean = "actividadManagedBean";
    }
    
}
