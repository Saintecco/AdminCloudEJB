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
import saludtec.admincloud.ejb.entidades.ComoSupo;

/**
 *
 * @author saintec
 */
@Stateless
public class ComoSupoImpl implements ComoSupoEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public ComoSupo guardar(ComoSupo comoSupo) {
        try {
            em.persist(comoSupo);
            return comoSupo;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ComoSupo editar(ComoSupo comoSupo) {
        try {
            em.merge(comoSupo);
            return comoSupo;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idComoSupo) {
        ComoSupo comoSupos = em.find(ComoSupo.class, idComoSupo);
        Integer ok = 0;
        if (comoSupos != null) {
            try {
                em.remove(comoSupos);
                ok = 200;
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
        return ok;
    }

    @Override
    public ComoSupo traer(Integer idComoSupo) {
        try {
            return em.find(ComoSupo.class, idComoSupo);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ComoSupo> listar(Clinicas clinica) {
        String queryStr = "SELECT c FROM ComoSupo c "
                + "WHERE c.idClinica = :idClinica "
                + "ORDER BY c.comoSupo";
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
