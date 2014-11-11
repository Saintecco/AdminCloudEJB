/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Convenios;
import saludtec.admincloud.ejb.entidades.Procedimientos;
import saludtec.admincloud.ejb.entidades.ConveniosProcedimientos;

/**
 *
 * @author saintec
 */
public interface ConveniosProcedimientosEjb {

    ConveniosProcedimientos guardar(ConveniosProcedimientos convenioProcedimiento);

    ConveniosProcedimientos editar(ConveniosProcedimientos convenioProcedimiento);

    Integer eliminar(Integer idConvenioProcedimiento);

    ConveniosProcedimientos traer(Integer idConvenioProcedimiento);

    ConveniosProcedimientos traer(Convenios convenio, Procedimientos procedimiento);

    List<ConveniosProcedimientos> listar(Convenios convenio);

}
