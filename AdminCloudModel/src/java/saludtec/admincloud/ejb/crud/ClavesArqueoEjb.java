/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import saludtec.admincloud.ejb.entidades.ClavesArqueoDeCaja;
import saludtec.admincloud.ejb.entidades.Clinicas;

/**
 *
 * @author saintec
 */
public interface ClavesArqueoEjb {
    
    ClavesArqueoDeCaja guardar(ClavesArqueoDeCaja claveArqueo);

    ClavesArqueoDeCaja editar(ClavesArqueoDeCaja claveArqueo);

    Integer eliminar(Integer idClaveArqueo);

    ClavesArqueoDeCaja traer(Integer idClaveArqueo);
    
    ClavesArqueoDeCaja traer(String claveArqueo, Clinicas clinica);
    
}
