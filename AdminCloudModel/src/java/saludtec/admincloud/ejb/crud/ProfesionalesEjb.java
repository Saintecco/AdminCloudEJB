/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.Profesionales;

/**
 *
 * @author saintec
 */
public interface ProfesionalesEjb {
    
    Profesionales guardar(Profesionales profesional);

    Profesionales editar(Profesionales profesional);

    Integer eliminar(Integer idProfesional);

    Profesionales traer(Integer idProfesional);

    List<Profesionales> listar(Clinicas clinica);
    
}
