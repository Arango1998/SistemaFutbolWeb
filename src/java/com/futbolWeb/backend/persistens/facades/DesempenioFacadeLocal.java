/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.backend.persistens.facades;

import com.futbolWeb.backend.persistence.entities.Desempenio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian Suesca
 */
@Local
public interface DesempenioFacadeLocal {

    void create(Desempenio desempenio);

    void edit(Desempenio desempenio);

    void remove(Desempenio desempenio);

    Desempenio find(Object id);

    List<Desempenio> findAll();

    List<Desempenio> findRange(int[] range);

    int count();
    
}
