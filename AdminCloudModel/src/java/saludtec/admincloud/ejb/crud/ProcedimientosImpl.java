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
import saludtec.admincloud.ejb.entidades.Procedimientos;
import saludtec.admincloud.ejb.entidades.Procedimientos;

/**
 *
 * @author saintec
 */
@Stateless
public class ProcedimientosImpl implements ProcedimientosEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public Procedimientos guardar(Procedimientos prodecimiento) {
        try {
            em.persist(prodecimiento);
            return prodecimiento;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Procedimientos editar(Procedimientos prodecimiento) {
        try {
            em.merge(prodecimiento);
            return prodecimiento;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idProcedimiento) {
        Integer ok = 0;
        try {
            Procedimientos prodecimientos = em.find(Procedimientos.class, idProcedimiento);
            if (prodecimientos != null) {
                em.remove(prodecimientos);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public Procedimientos traer(Integer idProcedimiento) {
        try {
            return em.find(Procedimientos.class, idProcedimiento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Procedimientos traer(String cups, Clinicas clinica) {
        try {
            String queryStr = "SELECT p FROM Procedimientos p "
                    + "WHERE p.cups = :cups "
                    + "AND p.idClinica = :idClinica "
                    + "ORDER BY p.procedimiento";
            Query query = em.createQuery(queryStr);
            query.setParameter("cups", cups);
            query.setParameter("idClinica", clinica);
            List<Procedimientos> procedimiento = query.getResultList();
            return procedimiento.get(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Procedimientos> listar(Clinicas clinica) {
        try {
            String queryStr = "SELECT p FROM Procedimientos p "
                    + "WHERE p.idClinica = :idClinica "
                    + "ORDER BY p.procedimiento";
            Query query = em.createQuery(queryStr);
            query.setParameter("idClinica", clinica);

            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
