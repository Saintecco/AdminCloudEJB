/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.ComoSupo;

/**
 *
 * @author saintec
 */
public interface ComoSupoEjb {
    
    ComoSupo guardar(ComoSupo comoSupo);

    ComoSupo editar(ComoSupo comoSupo);

    Integer eliminar(Integer idComoSupo);

    ComoSupo traer(Integer idComoSupo);

    List<ComoSupo> listar(Clinicas clinica);
    
}
