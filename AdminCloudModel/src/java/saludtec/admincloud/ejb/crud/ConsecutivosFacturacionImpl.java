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
import saludtec.admincloud.ejb.entidades.ConsecutivosFacturacion;

/**
 *
 * @author saintec
 */
@Stateless
public class ConsecutivosFacturacionImpl implements ConsecutivosFacturacionEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public ConsecutivosFacturacion guardar(ConsecutivosFacturacion consecutivoFacturacion) {
        try {
            em.persist(consecutivoFacturacion);
            return consecutivoFacturacion;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public ConsecutivosFacturacion editar(ConsecutivosFacturacion consecutivoFacturacion) {
        try {
            em.merge(consecutivoFacturacion);
            return consecutivoFacturacion;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idConsecutivoFacturacion) {
        Integer ok = 0;
        try {
            ConsecutivosFacturacion consecutivoFacturacions = em.find(ConsecutivosFacturacion.class, idConsecutivoFacturacion);
            if (consecutivoFacturacions != null) {
                em.remove(consecutivoFacturacions);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public ConsecutivosFacturacion traer(Integer idConsecutivoFacturacion) {
        try {
            return em.find(ConsecutivosFacturacion.class, idConsecutivoFacturacion);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<ConsecutivosFacturacion> listar(Clinicas clinica) {
        try {
            String queryStr = "SELECT c FROM ConsecutivosFacturacion t "
                    + "WHERE c.idClinica = :idClinica "
                    + "ORDER BY c.idConsecutivoFacturacion";
            Query query = em.createQuery(queryStr);
            query.setParameter("idClinica", clinica);
            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
