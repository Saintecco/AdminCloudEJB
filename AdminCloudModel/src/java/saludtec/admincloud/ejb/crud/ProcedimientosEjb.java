/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.Procedimientos;

/**
 *
 * @author saintec
 */
public interface ProcedimientosEjb {
    
    Procedimientos guardar(Procedimientos prodecimiento);

    Procedimientos editar(Procedimientos prodecimiento);

    Integer eliminar(Integer idProcedimiento);

    Procedimientos traer(Integer idProcedimiento);

    List<Procedimientos> listar(Clinicas clinica);
    
}
