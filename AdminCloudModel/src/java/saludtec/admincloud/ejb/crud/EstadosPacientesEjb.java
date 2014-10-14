/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.EstadosPacientes;

/**
 *
 * @author saintec
 */
public interface EstadosPacientesEjb {
    
    EstadosPacientes guardar(EstadosPacientes estadoPaciente);

    EstadosPacientes editar(EstadosPacientes estadoPaciente);

    Integer eliminar(Integer idEstadoPaciente);

    EstadosPacientes traer(Integer idEstadoPaciente);

    List<EstadosPacientes> listar(Clinicas clinica);
    
}
