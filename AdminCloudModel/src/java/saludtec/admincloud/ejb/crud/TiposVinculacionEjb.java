/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.TiposDeVinculacion;

/**
 *
 * @author saintec
 */
public interface TiposVinculacionEjb {

    TiposDeVinculacion guardar(TiposDeVinculacion tipoVinculacion);

    TiposDeVinculacion editar(TiposDeVinculacion tipoVinculacion);

    Integer eliminar(Integer idTipoVinculacion);

    TiposDeVinculacion traer(Integer idTipoVinculacion);

    List<TiposDeVinculacion> listar(Clinicas clinica);

}
