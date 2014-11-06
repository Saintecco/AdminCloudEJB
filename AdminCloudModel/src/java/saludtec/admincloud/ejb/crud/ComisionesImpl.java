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
import saludtec.admincloud.ejb.entidades.Comisiones;
import saludtec.admincloud.ejb.entidades.Procedimientos;
import saludtec.admincloud.ejb.entidades.Profesionales;
import saludtec.admincloud.ejb.entidades.Comisiones;

/**
 *
 * @author saintec
 */
@Stateless
public class ComisionesImpl implements ComisionesEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public Comisiones guardar(Comisiones comision) {
        try {
            em.persist(comision);
            return comision;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Comisiones editar(Comisiones comision) {
        try {
            em.merge(comision);
            return comision;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idComision) {
        Integer ok = 0;
        try {
            Comisiones comision = em.find(Comisiones.class, idComision);
            if (comision != null) {
                em.remove(comision);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public Comisiones traer(Integer idComision) {
        try {
            return em.find(Comisiones.class, idComision);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Comisiones traer(Profesionales profesional, Procedimientos procedimiento) {
        try {
            String queryStr = "SELECT r FROM Comisiones r "
                    + "WHERE r.idProfesional = :idProfesional "
                    + "AND r.idProcedimiento = :idProcedimiento ";
            Query query = em.createQuery(queryStr);
            query.setParameter("idProfesional", profesional);
            query.setParameter("idProcedimiento", procedimiento);
            List<Comisiones> rpc = query.getResultList();
            return rpc.get(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Comisiones> listar(Profesionales profesional) {
        try {
            String queryStr = "SELECT c FROM Comisiones c "
                    + "INNER JOIN c.idProcedimiento p"
                    + "WHERE c.idProfesional = :idProfesional "
                    + "ORDER BY p.procedimiento";
            Query query = em.createQuery(queryStr);
            query.setParameter("idProfesional", profesional);

            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }
    
}
