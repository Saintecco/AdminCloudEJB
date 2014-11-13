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
import saludtec.admincloud.ejb.entidades.Convenios;
import saludtec.admincloud.ejb.entidades.Procedimientos;
import saludtec.admincloud.ejb.entidades.ConveniosProcedimientos;

/**
 *
 * @author saintec
 */
@Stateless
public class ConveniosProcedimientosImpl implements ConveniosProcedimientosEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public ConveniosProcedimientos guardar(ConveniosProcedimientos convenioProcedimiento) {
        try {
            em.persist(convenioProcedimiento);
            return convenioProcedimiento;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ConveniosProcedimientos editar(ConveniosProcedimientos convenioProcedimiento) {
        try {
            em.merge(convenioProcedimiento);
            return convenioProcedimiento;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idConvenioProcedimiento) {
        Integer ok = 0;
        try {
            ConveniosProcedimientos convenioProcedimiento = em.find(ConveniosProcedimientos.class, idConvenioProcedimiento);
            if (convenioProcedimiento != null) {
                em.remove(convenioProcedimiento);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public ConveniosProcedimientos traer(Integer idConvenioProcedimiento) {
        try {
            return em.find(ConveniosProcedimientos.class, idConvenioProcedimiento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ConveniosProcedimientos> listar(Convenios convenio) {
        try {
            String queryStr = "SELECT c FROM ConveniosProcedimientos c "
                    + "INNER JOIN c.idProcedimiento p "
                    + "WHERE c.idConvenio = :idConvenio "
                    + "ORDER BY p.procedimiento";
            Query query = em.createQuery(queryStr);
            query.setParameter("idConvenio", convenio);

            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public ConveniosProcedimientos traer(Convenios convenio, Procedimientos procedimiento) {
        try {
            String queryStr = "SELECT c FROM ConveniosProcedimientos c "
                    + "WHERE c.idConvenio = :idConvenio "
                    + "AND c.idProcedimiento = :idProcedimiento";
            Query query = em.createQuery(queryStr);
            query.setParameter("idConvenio", convenio);
            query.setParameter("idProcedimiento", procedimiento);
            List<ConveniosProcedimientos> rpc = query.getResultList();
            return rpc.get(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
