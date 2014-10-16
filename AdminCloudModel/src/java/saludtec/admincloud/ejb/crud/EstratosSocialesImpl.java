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
import saludtec.admincloud.ejb.entidades.EstratosSociales;

/**
 *
 * @author saintec
 */
@Stateless
public class EstratosSocialesImpl implements EstratosSocialesEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public EstratosSociales guardar(EstratosSociales estratoSocial) {
        try {
            em.persist(estratoSocial);
            return estratoSocial;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public EstratosSociales editar(EstratosSociales estratoSocial) {
        try {
            em.merge(estratoSocial);
            return estratoSocial;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idEstratoSocial) {
        Integer ok = 0;
        try {
            EstratosSociales estratoSocials = em.find(EstratosSociales.class, idEstratoSocial);
            if (estratoSocials != null) {
                em.remove(estratoSocials);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public EstratosSociales traer(Integer idEstratoSocial) {
        try {
            return em.find(EstratosSociales.class, idEstratoSocial);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<EstratosSociales> listar(Clinicas clinica) {
        try {
            String queryStr = "SELECT e FROM EstratosSociales e "
                    + "WHERE e.idClinica = :idClinica "
                    + "ORDER BY e.estratoSocial";
            Query query = em.createQuery(queryStr);
            query.setParameter("idClinica", clinica);
            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
