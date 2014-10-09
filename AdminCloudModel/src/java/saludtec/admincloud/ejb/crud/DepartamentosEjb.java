/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.Departamentos;

/**
 *
 * @author saintec
 */
public interface DepartamentosEjb {
    
    Departamentos guardar(Departamentos departamento);

    Departamentos editar(Departamentos departamento);

    Integer eliminar(Integer idDepartamento);

    Departamentos traer(Integer idDepartamento);

    List<Departamentos> listar(Clinicas clinica);
    
}
