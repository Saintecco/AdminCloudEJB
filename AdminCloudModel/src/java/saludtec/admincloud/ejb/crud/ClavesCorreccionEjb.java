/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import saludtec.admincloud.ejb.entidades.ClavesCorreccionFactura;
import saludtec.admincloud.ejb.entidades.Clinicas;

/**
 *
 * @author saintec
 */
public interface ClavesCorreccionEjb {
    
    ClavesCorreccionFactura guardar(ClavesCorreccionFactura claveCorreccion);

    ClavesCorreccionFactura editar(ClavesCorreccionFactura claveCorreccion);

    Integer eliminar(Integer idClaveCorreccion);

    ClavesCorreccionFactura traer(Integer idClaveCorreccion);
    
    ClavesCorreccionFactura traer(String claveCorreccion, Clinicas clinica);
    
}
