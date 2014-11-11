/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.ConsecutivosFacturacion;

/**
 *
 * @author saintec
 */
public interface ConsecutivosFacturacionEjb {
    
    ConsecutivosFacturacion guardar(ConsecutivosFacturacion consecutivoFacturacion);

    ConsecutivosFacturacion editar(ConsecutivosFacturacion consecutivoFacturacion);

    Integer eliminar(Integer idConsecutivoFacturacion);

    ConsecutivosFacturacion traer(Integer idConsecutivoFacturacion);

    List<ConsecutivosFacturacion> listar(Clinicas clinica);
    
}
