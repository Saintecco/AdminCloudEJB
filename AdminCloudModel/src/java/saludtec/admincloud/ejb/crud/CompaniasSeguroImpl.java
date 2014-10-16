/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.CompaniasDeSeguros;

/**
 *
 * @author saintec
 */
@Stateless
public class CompaniasSeguroImpl implements CompaniasSeguroEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public CompaniasDeSeguros guardar(CompaniasDeSeguros companiaSeguro) {
        try {
            em.persist(companiaSeguro);
            return companiaSeguro;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public CompaniasDeSeguros editar(CompaniasDeSeguros companiaSeguro) {
        try {
            em.merge(companiaSeguro);
            return companiaSeguro;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idCompaniaSeguro) {
        Integer ok = 0;
        try {
            CompaniasDeSeguros companiaSeguros = em.find(CompaniasDeSeguros.class, idCompaniaSeguro);
            if (companiaSeguros != null) {
                em.remove(companiaSeguros);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public CompaniasDeSeguros traer(Integer idCompaniaSeguro) {
        try {
            return em.find(CompaniasDeSeguros.class, idCompaniaSeguro);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<CompaniasDeSeguros> listar(Clinicas clinica) {
        String queryStr = "SELECT c FROM CompaniasDeSeguros c "
                + "WHERE c.idClinica = :idClinica "
                + "ORDER BY c.companiaDeSeguro";
        Query query = em.createQuery(queryStr);
        query.setParameter("idClinica", clinica);
        try {
            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
