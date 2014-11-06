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
import saludtec.admincloud.ejb.entidades.RelProcedimientosConvenios;

/**
 *
 * @author saintec
 */
@Stateless
public class RelProcedimientosConveniosImpl implements RelProcedimientosConveniosEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public RelProcedimientosConvenios guardar(RelProcedimientosConvenios relProcedimientoConvenio) {
        try {
            em.persist(relProcedimientoConvenio);
            return relProcedimientoConvenio;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public RelProcedimientosConvenios editar(RelProcedimientosConvenios relProcedimientoConvenio) {
        try {
            em.merge(relProcedimientoConvenio);
            return relProcedimientoConvenio;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idRelProcedimientoConvenio) {
        Integer ok = 0;
        try {
            RelProcedimientosConvenios relProcedimientoConvenio = em.find(RelProcedimientosConvenios.class, idRelProcedimientoConvenio);
            if (relProcedimientoConvenio != null) {
                em.remove(relProcedimientoConvenio);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public RelProcedimientosConvenios traer(Integer idRelProcedimientoConvenio) {
        try {
            return em.find(RelProcedimientosConvenios.class, idRelProcedimientoConvenio);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<RelProcedimientosConvenios> listar(Convenios convenio) {
        try {
            String queryStr = "SELECT r FROM RelProcedimientosConvenios r "
                    + "INNER JOIN r.Procedimientos p"
                    + "WHERE r.idConvenio = :idConvenio "
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
    public RelProcedimientosConvenios traer(Convenios convenio, Procedimientos procedimiento) {
        try {
            String queryStr = "SELECT r FROM RelProcedimientosConvenios r "
                    + "WHERE r.idConvenio = :idConvenio "
                    + "AND r.idProcedimiento = :idProcedimiento "
                    + "ORDER BY p.procedimiento";
            Query query = em.createQuery(queryStr);
            query.setParameter("idConvenio", convenio);
            query.setParameter("idProcedimiento", procedimiento);
            List<RelProcedimientosConvenios> rpc = query.getResultList();
            return rpc.get(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
