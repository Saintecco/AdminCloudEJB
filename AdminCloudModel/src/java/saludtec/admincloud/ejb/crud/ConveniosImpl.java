/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludtec.admincloud.ejb.crud;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.entidades.Convenios;

/**
 *
 * @author saintec
 */
@Stateless
public class ConveniosImpl implements ConveniosEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public Convenios guardar(Convenios convenio) {
        try {
            em.persist(convenio);
            return convenio;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Convenios editar(Convenios convenio) {
        try {
            em.merge(convenio);
            return convenio;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idConvenio) {
        Integer ok = 0;
        try {
            Convenios convenios = em.find(Convenios.class, idConvenio);
            if (convenios != null) {
                em.remove(convenios);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public Convenios traer(Integer idConvenio) {
        try {
            return em.find(Convenios.class, idConvenio);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Convenios traer(String codigo, Clinicas clinica) {
        try {
            String queryStr = "SELECT c FROM Convenios c "
                    + "WHERE c.codigoConvenio = :codigo "
                    + "AND c.idClinica = :idClinica "
                    + "ORDER BY c.convenio";
            Query query = em.createQuery(queryStr);
            query.setParameter("codigo", codigo);
            query.setParameter("idClinica", clinica);
            List<Convenios> convenio = query.getResultList();
            return convenio.get(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Convenios> listar(Clinicas clinica) {
        try {
            String queryStr = "SELECT c FROM Convenios c "
                    + "WHERE c.idClinica = :idClinica "
                    + "ORDER BY c.convenio";
            Query query = em.createQuery(queryStr);
            query.setParameter("idClinica", clinica);

            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
