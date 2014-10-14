/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.EstratosSociales;

/**
 *
 * @author saintec
 */
public interface EstratosSocialesEjb {
    
    EstratosSociales guardar(EstratosSociales estratoSocial);

    EstratosSociales editar(EstratosSociales estratoSocial);

    Integer eliminar(Integer idEstratoSocial);

    EstratosSociales traer(Integer idEstratoSocial);

    List<EstratosSociales> listar(Clinicas clinica);
}
