/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.Comisiones;
import saludtec.admincloud.ejb.entidades.Procedimientos;
import saludtec.admincloud.ejb.entidades.Profesionales;

/**
 *
 * @author saintec
 */
public interface ComisionesEjb {

    Comisiones guardar(Comisiones comision);

    Comisiones editar(Comisiones comision);

    Integer eliminar(Integer idComision);

    Comisiones traer(Integer idComision);

    Comisiones traer(Profesionales profesional, Procedimientos procedimiento);

    List<Comisiones> listar(Profesionales profesional);

}
