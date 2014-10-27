/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.Convenios;

/**
 *
 * @author saintec
 */
public interface ConveniosEjb {

    Convenios guardar(Convenios convenio);

    Convenios editar(Convenios convenio);

    Integer eliminar(Integer idConvenio);

    Convenios traer(Integer idConvenio);

    Convenios traer(String codigo, Clinicas clinica);

    List<Convenios> listar(Clinicas clinica);

}
