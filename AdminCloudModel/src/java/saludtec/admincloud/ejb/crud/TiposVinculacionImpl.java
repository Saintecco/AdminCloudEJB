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
import saludtec.admincloud.ejb.entidades.TiposDeVinculacion;

/**
 *
 * @author saintec
 */
@Stateless
public class TiposVinculacionImpl implements TiposVinculacionEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public TiposDeVinculacion guardar(TiposDeVinculacion tipoVinculacion) {
        try {
            em.persist(tipoVinculacion);
            return tipoVinculacion;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public TiposDeVinculacion editar(TiposDeVinculacion tipoVinculacion) {
        try {
            em.merge(tipoVinculacion);
            return tipoVinculacion;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idTipoVinculacion) {
        Integer ok = 0;
        try {
            TiposDeVinculacion tipoVinculacions = em.find(TiposDeVinculacion.class, idTipoVinculacion);
            if (tipoVinculacions != null) {
                em.remove(tipoVinculacions);
                ok = 200;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public TiposDeVinculacion traer(Integer idTipoVinculacion) {
        try {
            return em.find(TiposDeVinculacion.class, idTipoVinculacion);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<TiposDeVinculacion> listar(Clinicas clinica) {
        try {
            String queryStr = "SELECT t FROM TiposDeVinculacion t "
                    + "WHERE t.idClinica = :idClinica "
                    + "ORDER BY t.tipoDeVinculacion";
            Query query = em.createQuery(queryStr);
            query.setParameter("idClinica", clinica);
            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
