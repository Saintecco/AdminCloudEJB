/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.CategoriasProcedimientos;
import saludtec.admincloud.ejb.entidades.Clinicas;

/**
 *
 * @author saintec
 */
public interface CategoriasProcedimientosEjb {

    CategoriasProcedimientos guardar(CategoriasProcedimientos categoriaProcedimiento);

    CategoriasProcedimientos editar(CategoriasProcedimientos categoriaProcedimiento);

    Integer eliminar(Integer idCategoriaProcedimiento);

    CategoriasProcedimientos traer(Integer idCategoriaProcedimiento);

    List<CategoriasProcedimientos> listar(Clinicas clinica);

}
