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
import saludtec.admincloud.ejb.entidades.ClavesCorreccionFactura;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.utilidades.UtilidadMD5;

/**
 *
 * @author saintec
 */
@Stateless
public class ClavesCorreccionImpl implements ClavesCorrecionEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public ClavesCorreccionFactura guardar(ClavesCorreccionFactura claveCorreccion) {
        try {
            em.persist(claveCorreccion);
            return claveCorreccion;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ClavesCorreccionFactura editar(ClavesCorreccionFactura claveCorreccion) {
        try {
            em.merge(claveCorreccion);
            return claveCorreccion;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idClaveCorreccion) {
        Integer ok = 0;
        try {
            ClavesCorreccionFactura claveCorreccions = em.find(ClavesCorreccionFactura.class, idClaveCorreccion);
            if (claveCorreccions != null) {
                em.remove(claveCorreccions);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public ClavesCorreccionFactura traer(Integer idClaveCorreccion) {
        try {
            return em.find(ClavesCorreccionFactura.class, idClaveCorreccion);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public ClavesCorreccionFactura traer(String claveCorreccion, Clinicas clinica) {
        try {
            String queryStr = "SELECT c FROM ClavesCorreccionFactura c "
                    + "WHERE c.claveCorreccionFactura = :clave "
                    + "AND c.idClinica = :idClinica ";
            Query query = em.createQuery(queryStr);
            query.setParameter("clave", UtilidadMD5.encriptar(claveCorreccion));
            query.setParameter("idClinica", clinica);
            List<ClavesCorreccionFactura> ccf = query.getResultList();
            return ccf.get(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
