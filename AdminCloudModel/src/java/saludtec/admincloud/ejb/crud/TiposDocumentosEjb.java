/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.TiposDeDocumentos;

/**
 *
 * @author saintec
 */
public interface TiposDocumentosEjb {

    TiposDeDocumentos guardar(TiposDeDocumentos tipoDocumento);

    TiposDeDocumentos editar(TiposDeDocumentos tipoDocumento);

    Integer eliminar(Integer idTipoDocumento);

    TiposDeDocumentos traer(Integer idTipoDocumento);

    List<TiposDeDocumentos> listar(Clinicas clinica);

    String listarr();

}
