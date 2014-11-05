/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;

/**
 *
 * @author saintec
 */
public interface ClinicasEjb {

    Clinicas guardar(Clinicas clinica);

    Clinicas editar(Clinicas clinica);

    Integer eliminar(Integer idClinica);

    Clinicas traer(Integer idClinica);

    List<Clinicas> listar();

}
