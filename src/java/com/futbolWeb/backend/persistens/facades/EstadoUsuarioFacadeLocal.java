/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.futbolWeb.backend.persistens.facades;

import com.futbolWeb.backend.persistence.entities.EstadoUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cristian Suesca
 */
@Local
public interface EstadoUsuarioFacadeLocal {

    void create(EstadoUsuario estadoUsuario);

    void edit(EstadoUsuario estadoUsuario);

    void remove(EstadoUsuario estadoUsuario);

    EstadoUsuario find(Object id);

    List<EstadoUsuario> findAll();

    List<EstadoUsuario> findRange(int[] range);

    int count();
    
}
