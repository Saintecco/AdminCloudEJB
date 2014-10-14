/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package saludtec.admincloud.ejb.crud;

import java.util.List;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.CompaniasDeSeguros;

/**
 *
 * @author saintec
 */
public interface CompaniasSeguroEjb {
    
    CompaniasDeSeguros guardar(CompaniasDeSeguros companiaSeguro);

    CompaniasDeSeguros editar(CompaniasDeSeguros companiaSeguro);

    Integer eliminar(Integer idCompaniaSeguro);

    CompaniasDeSeguros traer(Integer idCompaniaSeguro);

    List<CompaniasDeSeguros> listar(Clinicas clinica);
    
}
