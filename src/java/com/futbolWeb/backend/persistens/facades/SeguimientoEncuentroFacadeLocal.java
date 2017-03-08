/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.backend.persistens.facades;

import com.futbolWeb.backend.persistence.entities.SeguimientoEncuentro;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian Suesca
 */
@Local
public interface SeguimientoEncuentroFacadeLocal {

    void create(SeguimientoEncuentro seguimientoEncuentro);

    void edit(SeguimientoEncuentro seguimientoEncuentro);

    void remove(SeguimientoEncuentro seguimientoEncuentro);

    SeguimientoEncuentro find(Object id);

    List<SeguimientoEncuentro> findAll();

    List<SeguimientoEncuentro> findRange(int[] range);

    int count();
    
}
