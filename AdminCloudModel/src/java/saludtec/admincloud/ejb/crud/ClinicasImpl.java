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

/**
 *
 * @author saintec
 */
@Stateless
public class ClinicasImpl implements ClinicasEjb {
    
    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public Clinicas guardar(Clinicas clinica) {
        try {
            em.persist(clinica);
            return clinica;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Clinicas editar(Clinicas clinica) {
        try {
            em.merge(clinica);
            return clinica;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idClinica) {
        Integer ok = 0;
        try {
            Clinicas clinicas = em.find(Clinicas.class, idClinica);
            if (clinicas != null) {
                em.remove(clinicas);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public Clinicas traer(Integer idClinica) {
        try {
            return em.find(Clinicas.class, idClinica);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Clinicas> listar() {
        try {
            String queryStr = "SELECT c FROM Clinicas c "
                    + "ORDER BY c.razonSocial";
            Query query = em.createQuery(queryStr);

            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
