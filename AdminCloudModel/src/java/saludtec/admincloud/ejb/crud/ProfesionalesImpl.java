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
import saludtec.admincloud.ejb.entidades.Profesionales;

/**
 *
 * @author saintec
 */
@Stateless
public class ProfesionalesImpl implements ProfesionalesEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public Profesionales guardar(Profesionales profesional) {
        try {
            em.persist(profesional);
            return profesional;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Profesionales editar(Profesionales profesional) {
        try {
            em.merge(profesional);
            return profesional;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idProfesional) {
        Integer ok = 0;
        try {
            Profesionales profesionals = em.find(Profesionales.class, idProfesional);
            if (profesionals != null) {
                em.remove(profesionals);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public Profesionales traer(Integer idProfesional) {
        try {
            return em.find(Profesionales.class, idProfesional);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Profesionales> listar(Clinicas clinica) {
        try {
            String queryStr = "SELECT p FROM Profesionales p "
                    + "WHERE p.idClinica = :idClinica "
                    + "ORDER BY p.nombre";
            Query query = em.createQuery(queryStr);
            query.setParameter("idClinica", clinica);

            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
