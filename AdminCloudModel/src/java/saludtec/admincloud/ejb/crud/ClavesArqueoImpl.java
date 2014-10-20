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
import saludtec.admincloud.ejb.entidades.ClavesArqueoDeCaja;
import saludtec.admincloud.ejb.entidades.ClavesArqueoDeCaja;
import saludtec.admincloud.ejb.entidades.Clinicas;
import saludtec.admincloud.ejb.utilidades.UtilidadMD5;

/**
 *
 * @author saintec
 */
@Stateless
public class ClavesArqueoImpl implements ClavesArqueoEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public ClavesArqueoDeCaja guardar(ClavesArqueoDeCaja claveArqueo) {
        try {
            em.persist(claveArqueo);
            return claveArqueo;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ClavesArqueoDeCaja editar(ClavesArqueoDeCaja claveArqueo) {
        try {
            em.merge(claveArqueo);
            return claveArqueo;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idClaveArqueo) {
        Integer ok = 0;
        try {
            ClavesArqueoDeCaja claveArqueos = em.find(ClavesArqueoDeCaja.class, idClaveArqueo);
            if (claveArqueos != null) {
                em.remove(claveArqueos);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public ClavesArqueoDeCaja traer(Integer idClaveArqueo) {
        try {
            return em.find(ClavesArqueoDeCaja.class, idClaveArqueo);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public ClavesArqueoDeCaja traer(String claveArqueo, Clinicas clinica) {
        try {
            String queryStr = "SELECT c FROM ClavesArqueoDeCaja c "
                    + "WHERE c.claveArqueoDeCaja = :clave "
                    + "AND c.idClinica = :idClinica ";
            Query query = em.createQuery(queryStr);
            query.setParameter("clave", UtilidadMD5.encriptar(claveArqueo));
            query.setParameter("idClinica", clinica);
            List<ClavesArqueoDeCaja> cac = query.getResultList();
            return cac.get(0);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
