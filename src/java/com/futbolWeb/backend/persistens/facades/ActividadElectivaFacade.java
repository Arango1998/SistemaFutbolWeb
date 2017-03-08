/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.backend.persistens.facades;

import com.futbolWeb.backend.persistence.entities.ActividadElectiva;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Cristian Suesca
 */
@Stateless
public class ActividadElectivaFacade extends AbstractFacade<ActividadElectiva> implements ActividadElectivaFacadeLocal {

    @PersistenceContext(unitName = "FutbolWebPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActividadElectivaFacade() {
        super(ActividadElectiva.class);
    }
    
}
