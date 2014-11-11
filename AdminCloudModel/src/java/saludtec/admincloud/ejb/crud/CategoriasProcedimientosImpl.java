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
import saludtec.admincloud.ejb.entidades.CategoriasProcedimientos;
import saludtec.admincloud.ejb.entidades.Clinicas;

/**
 *
 * @author saintec
 */
@Stateless
public class CategoriasProcedimientosImpl implements CategoriasProcedimientosEjb {

    @PersistenceContext(unitName = "AdminCloudModelPU")
    EntityManager em;

    @Override
    public CategoriasProcedimientos guardar(CategoriasProcedimientos categoriaProcedimiento) {
        try {
            em.persist(categoriaProcedimiento);
            return categoriaProcedimiento;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public CategoriasProcedimientos editar(CategoriasProcedimientos categoriaProcedimiento) {
        try {
            em.merge(categoriaProcedimiento);
            return categoriaProcedimiento;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Integer eliminar(Integer idCategoriaProcedimiento) {
        Integer ok = 0;
        try {
            CategoriasProcedimientos categoriaProcedimientos = em.find(CategoriasProcedimientos.class, idCategoriaProcedimiento);
            if (categoriaProcedimientos != null) {
                em.remove(categoriaProcedimientos);

            }
            ok = 200;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return ok;
    }

    @Override
    public CategoriasProcedimientos traer(Integer idCategoriaProcedimiento) {
        try {
            return em.find(CategoriasProcedimientos.class, idCategoriaProcedimiento);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<CategoriasProcedimientos> listar(Clinicas clinica) {
        try {
            String queryStr = "SELECT c FROM CategoriasProcedimientos c "
                    + "WHERE c.idClinica = :idClinica "
                    + "ORDER BY c.categoriaProcedimiento";
            Query query = em.createQuery(queryStr);
            query.setParameter("idClinica", clinica);

            return query.getResultList();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
