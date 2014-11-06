/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Convenios;
import saludtec.admincloud.ejb.entidades.Procedimientos;
import saludtec.admincloud.ejb.entidades.RelProcedimientosConvenios;

/**
 *
 * @author saintec
 */
public interface RelProcedimientosConveniosEjb {

    RelProcedimientosConvenios guardar(RelProcedimientosConvenios relProcedimientoConvenio);

    RelProcedimientosConvenios editar(RelProcedimientosConvenios relProcedimientoConvenio);

    Integer eliminar(Integer idRelProcedimientoConvenio);

    RelProcedimientosConvenios traer(Integer idRelProcedimientoConvenio);

    RelProcedimientosConvenios traer(Convenios convenio, Procedimientos procedimiento);

    List<RelProcedimientosConvenios> listar(Convenios convenio);

}
